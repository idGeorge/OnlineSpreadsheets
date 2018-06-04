package ua.remzsolutions.onlinespreadsheets.web.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryTreeDTO;
import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DirectoryEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.AccessLevelService;
import ua.remzsolutions.onlinespreadsheets.domain.services.DirectoryService;
import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import ua.remzsolutions.onlinespreadsheets.util.DTOConverterUtil;
import ua.remzsolutions.onlinespreadsheets.web.exception.ResourceNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.exception.UnauthorizedAccessException;
import ua.remzsolutions.onlinespreadsheets.web.exception.UserNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.request.*;
import ua.remzsolutions.onlinespreadsheets.web.response.CreateDirectoryResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.DirectoryLookupResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.DirectoryTreeResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.GetDirectoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.Iterator;

@RestController
@RequestMapping("/directories")
public class DirectoryController {

    private static final Logger LOGGER = LogManager.getLogger();

    private final DirectoryService directoryService;

    private final UserService userService;

    private final AccessLevelService accessLevelService;

    private final DTOConverterUtil<DirectoryEntity, DirectoryDTO> converter;

    @Autowired
    public DirectoryController(DirectoryService directoryService,
                               UserService userService,
                               DTOConverterUtil<DirectoryEntity, DirectoryDTO> converter,
                               AccessLevelService accessLevelService) {
        this.directoryService = directoryService;
        this.userService = userService;
        this.converter = converter;
        this.accessLevelService = accessLevelService;
    }


    @ModelAttribute("user")
    public UserEntity getUser(HttpServletRequest servletRequest) {
        RoutingData routingData = (RoutingData) servletRequest.getAttribute("routingData");
        UserEntity user = userService.findOne(routingData.getUserId());
        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @GetMapping("/tree")
    public ResponseEntity<DirectoryTreeResponse> getDirectoryTree(@ModelAttribute("user") UserEntity user) {
        DirectoryEntity directory = directoryService.findFirstByName("root");
        if (directory == null) {
            DirectoryEntity rootDirectory = new DirectoryEntity()
                    .setName("root")
                    .setAccessLevel(accessLevelService.findWithSmallestPriority())
                    .setDateCreated(new Date());
            directory = directoryService.save(rootDirectory);
        }


        removeForbiddenDirectoriesAndDocuments(directory, user.getAccessLevel());

        DirectoryTreeDTO tree = new DirectoryTreeDTO()
                .setRoot(converter.convertToDto(directory));

        return ResponseEntity.ok(new DirectoryTreeResponse(tree));
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetDirectoryResponse> getDirectory(GetDirectoryRequest request,
                                                             @ModelAttribute("user") UserEntity user) {
        DirectoryEntity directory = directoryService.findOne(request.getId());
        if (directory == null) {
            throw new ResourceNotFoundException();
        }

        if (user.getAccessLevel().compareTo(directory.getAccessLevel()) < 0) {
            throw new UnauthorizedAccessException();
        }

        return ResponseEntity.ok(new GetDirectoryResponse(converter.convertToDto(directory)));
    }

    @DeleteMapping("/{id}") // TODO: test
    public ResponseEntity deleteDirectory(DeleteDirectoryRequest request,
                                          @ModelAttribute("user") UserEntity user) {
        DirectoryEntity directory = directoryService.findOne(request.getId());
        if (directory == null) {
            throw new ResourceNotFoundException();
        }

        if (user.getAccessLevel().compareTo(directory.getAccessLevel()) < 0) {
            throw new UnauthorizedAccessException();
        }

        directoryService.delete(directory);

        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/{id}") // TODO: test
    public ResponseEntity updateDirectory(@PathVariable("id") Long directoryId,
                                          @RequestBody UpdateDirectoryRequest requestBody,
                                          @ModelAttribute("user") UserEntity user) {

        DirectoryEntity directory = directoryService.findOne(directoryId);
        if (directory == null) {
            throw new ResourceNotFoundException();
        }

        if (user.getAccessLevel().compareTo(directory.getAccessLevel()) < 0) {
            throw new UnauthorizedAccessException();
        }

        if (requestBody.getParentDirectoryId() != null) {
            DirectoryEntity parentDirectory = directoryService.findOne(requestBody.getParentDirectoryId());

            if (parentDirectory == null) {
                throw new ResourceNotFoundException("Directory with id '" + requestBody.getParentDirectoryId() + "' not found.");
            } else {
                directory.setParentDirectory(parentDirectory);
            }
        }


        if (requestBody.getName() != null && !requestBody.getName().isEmpty()) {
            directory.setName(requestBody.getName());
        }

        if (requestBody.getAccessLevelId() != null) {
            AccessLevelEntity accessLevel = accessLevelService.findOne(requestBody.getAccessLevelId());

            if (accessLevel == null) {
                throw new ResourceNotFoundException("Access level with id '" + requestBody.getAccessLevelId() + "' not found.");
            } else {
                directory.setAccessLevel(accessLevel);
            }
        }

        directory = directoryService.save(directory);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/") // TODO: Test
    public ResponseEntity<CreateDirectoryResponse> createDirectory(@Valid @RequestBody CreateDirectoryRequest requestBody,
                                                                   @ModelAttribute("user") UserEntity user) {

        AccessLevelEntity accessLevel = accessLevelService.findOne(requestBody.getAccessLevelId());
        if (accessLevel == null) {
            throw new ResourceNotFoundException("Access level with id '" + requestBody.getAccessLevelId() + "' not found.");
        }

        if (user.getAccessLevel().compareTo(accessLevel) < 0) {
            throw new UnauthorizedAccessException("You are not allowed to create directories with access level '" + accessLevel.getPriority() + "'.");
        }

        DirectoryEntity parentDirectory = directoryService.findOne(requestBody.getParenDirectoryId());
        if (parentDirectory == null) {
            throw new ResourceNotFoundException("Directory with id '" + requestBody.getParenDirectoryId() + "' not found.");
        }
        if (user.getAccessLevel().compareTo(parentDirectory.getAccessLevel()) < 0) {
            throw new UnauthorizedAccessException("You are not allowed to create directories in this directory.");
        }

        DirectoryEntity directoryEntity = new DirectoryEntity()
                .setDateCreated(new Date())
                .setName(requestBody.getName())
                .setAccessLevel(accessLevel)
                .setParentDirectory(parentDirectory);
        directoryEntity = directoryService.save(directoryEntity);

        return ResponseEntity.ok(new CreateDirectoryResponse(converter.convertToDto(directoryEntity)));
    }

    @GetMapping(value = "/", params = {"parentDirectoryId", "name", "page", "pageSize"}) // TODO: Test
    public ResponseEntity<DirectoryLookupResponse> lookupDirectories(DirectoryLookupRequest request,
                                                                     @ModelAttribute("user") UserEntity user) {

        LOGGER.info("Request {}", request);
        DirectoryEntity parentDirectory = directoryService.findOne(request.getParentDirectoryId());
        if (parentDirectory == null) {
            throw new ResourceNotFoundException("Directory with id '" + request.getParentDirectoryId() + "' not found");
        }
        if (user.getAccessLevel().compareTo(parentDirectory.getAccessLevel()) < 0) {
            throw new UnauthorizedAccessException("You are not allowed to search in this directory");
        }

        PageRequest pageRequest = new PageRequest(request.getPage(), request.getPageSize());
        Page<DirectoryEntity> directoryEntityPage =
                directoryService.findByNameContainingOrParentDirectory(request.getName(), parentDirectory, pageRequest);

        LOGGER.info("Content size {}", directoryEntityPage.getContent().size());

        return ResponseEntity.ok(new DirectoryLookupResponse(converter.convertToDto(directoryEntityPage, pageRequest)));
    }


    private void removeForbiddenDirectoriesAndDocuments(DirectoryEntity directory, AccessLevelEntity userAccessLevel) {

        for (Iterator<DirectoryEntity> iterator = directory.getSubDirectories().iterator(); iterator.hasNext(); ) {
            DirectoryEntity subDirectory = iterator.next();
            subDirectory.getDocuments()
                    .removeIf(documentEntity -> userAccessLevel.compareTo(documentEntity.getAccessLevel()) < 0);

            if (userAccessLevel.compareTo(subDirectory.getAccessLevel()) < 0) {
                iterator.remove();
            }

            removeForbiddenDirectoriesAndDocuments(subDirectory, userAccessLevel);
        }
    }

}