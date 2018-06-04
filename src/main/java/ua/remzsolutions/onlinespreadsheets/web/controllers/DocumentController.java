package ua.remzsolutions.onlinespreadsheets.web.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;
import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.DocumentEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.AccessLevelService;
import ua.remzsolutions.onlinespreadsheets.domain.services.DocumentService;
import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import ua.remzsolutions.onlinespreadsheets.util.DTOConverterUtil;
import ua.remzsolutions.onlinespreadsheets.web.exception.ResourceNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.exception.UnauthorizedAccessException;
import ua.remzsolutions.onlinespreadsheets.web.exception.UserNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.request.*;
import ua.remzsolutions.onlinespreadsheets.web.response.CreateDocumentResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.DocumentLookupResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.GetDocumentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/document")
public class DocumentController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private DTOConverterUtil<DocumentEntity, DocumentDTO> converter;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private AccessLevelService accessLevelService;


    @ModelAttribute("user")
    public UserEntity getUser(HttpServletRequest servletRequest) {
        TokenPayload tokenPayload = (TokenPayload) servletRequest.getAttribute("tokenPayload");
        UserEntity user = userService.findOne(tokenPayload.getUserId());
        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @GetMapping("/{id}") // TODO: test
    public ResponseEntity<GetDocumentResponse> getDocument(GetDocumentRequest request,
                                                           @ModelAttribute("user") UserEntity user) {
        DocumentEntity documentEntity = documentService.findOne(request.getId());
        if (documentEntity == null) {
            throw new ResourceNotFoundException("Document with id '" + request.getId() + "' not found.");
        }

        if (user.getAccessLevel().compareTo(documentEntity.getAccessLevel()) < 0) {
            throw new UnauthorizedAccessException("You do not have permission to view this resource.");
        }

        return ResponseEntity.ok(new GetDocumentResponse(converter.convertToDto(documentEntity)));
    }

    @GetMapping(value = "/", params = {"title", "author", ""}) // TODO: test
    public ResponseEntity<DocumentLookupResponse> lookUpDocuments(DocumentLookupRequest request,
                                                                  @ModelAttribute("user") UserEntity user) {

        UserEntity author = userService.findByUsername(request.getUsername());
        if (author == null) {
            throw new ResourceNotFoundException("User with username '" + request.getUsername() + "' not found.");
        }

        PageRequest pageRequest = new PageRequest(request.getPage(), request.getSize());
        Page<DocumentEntity> documentEntityPage = documentService.findByTitleContainingOrAuthorOrArchived(
                request.getTitle(), author, request.getArchived(), pageRequest);

        return ResponseEntity.ok(new DocumentLookupResponse(converter.convertToDto(documentEntityPage, pageRequest)));
    }

    @PatchMapping("/{id}") // TODO: test
    public ResponseEntity updateDocument(@ModelAttribute("user") UserEntity user,
                                         @PathVariable("id") Long documentId,
                                         @RequestBody UpdateDocumentRequest request) {

        DocumentEntity documentEntity = documentService.findOne(documentId);
        if (documentEntity == null) {
            throw new ResourceNotFoundException("Document with id '" + documentId + "' not found.");
        }

        AccessLevelEntity accessLevelEntity = accessLevelService.findOne(request.getAccessLevelId());
        if (accessLevelEntity == null) {
            throw new ResourceNotFoundException("Access level with id '" + request.getAccessLevelId());
        } else {
            documentEntity.setAccessLevel(accessLevelEntity);
        }

        if (request.getArchived() != null) {
            documentEntity.setArchived(request.getArchived());
        }

        if (request.getTitle() != null) {
            documentEntity.setTitle(request.getTitle());
        }

        documentEntity.setDateModified(new Date());
        documentEntity = documentService.save(documentEntity);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/") // TODO: test
    public ResponseEntity<CreateDocumentResponse> createDocument(@Valid @RequestBody CreateDocumentRequest request,
                                                                 @ModelAttribute("user") UserEntity user) {

        AccessLevelEntity accessLevelEntity = accessLevelService.findOne(request.getAccessLevelId());
        if (accessLevelEntity == null) {
            throw new ResourceNotFoundException("Access level with id '" + request.getAccessLevelId());
        }

        if (user.getAccessLevel().compareTo(accessLevelEntity) < 0) {
            throw new UnauthorizedAccessException("You are not allowed to create resource with this access level.");
        }

        Date currentDate = new Date();
        DocumentEntity documentEntity = documentService.save(DocumentEntity.builder()
                .accessLevel(accessLevelEntity)
                .archived(false)
                .title(request.getTitle())
                .dateCreated(currentDate)
                .dateModified(currentDate)
                .author(user)
                .sheets(new HashMap<>())
                .build());

        return ResponseEntity.ok(new CreateDocumentResponse(converter.convertToDto(documentEntity)));
    }

}