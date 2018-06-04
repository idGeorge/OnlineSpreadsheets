package ua.remzsolutions.onlinespreadsheets.web.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;
import ua.remzsolutions.onlinespreadsheets.domain.entity.AccessLevelEntity;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.AccessLevelService;
import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import ua.remzsolutions.onlinespreadsheets.util.DTOConverterUtil;
import ua.remzsolutions.onlinespreadsheets.web.exception.ResourceNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.exception.UnauthorizedAccessException;
import ua.remzsolutions.onlinespreadsheets.web.exception.UserNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.request.CreateUserRequest;
import ua.remzsolutions.onlinespreadsheets.web.request.TokenPayload;
import ua.remzsolutions.onlinespreadsheets.web.request.UpdateUserRequest;
import ua.remzsolutions.onlinespreadsheets.web.request.UserLookupRequest;
import ua.remzsolutions.onlinespreadsheets.web.response.CreateUserResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.GetUserResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.UserLookupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private AccessLevelService accessLevelService;

    @Autowired
    private DTOConverterUtil<UserEntity, UserDTO> converter;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(path = "/{id}") // TODO: test
    public ResponseEntity<GetUserResponse> getUser(@PathVariable("id") String userId,
                                                   @ModelAttribute UserEntity user) {
        UserEntity userEntity = userService.findOne(userId);
        if (userEntity == null) {
            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(new GetUserResponse(converter.convertToDto(userEntity)));
    }

    // TODO: test
    @GetMapping(path = "/", params = {"username", "firstName", "lastName", "fired", "accessLevelId", "page", "size"})
    public ResponseEntity<UserLookupResponse> searchUsers(@ModelAttribute UserEntity user,
                                                          @Valid UserLookupRequest request) {
        LOGGER.info("Request {}", request);
        AccessLevelEntity accessLevel = accessLevelService.findOne(request.getAccessRoleId());
        if (accessLevel == null) {
            throw new ResourceNotFoundException("Access level with id '" + request.getAccessRoleId() + "' not found.");
        }
        PageRequest pageRequest = new PageRequest(request.getPage(), request.getPageSize());
        Page<UserEntity> userEntityPage = userService.findByFields(request.getUsername(), request.getLastName(),
                request.getLastName(), request.getFired(), accessLevel, pageRequest);

        return ResponseEntity.ok(new UserLookupResponse(converter.convertToDto(userEntityPage, pageRequest)));
    }

    @PatchMapping(path = "/{id}") // TODO: test
    public ResponseEntity updateUser(@ModelAttribute UserEntity user,
                                     @PathVariable String userId,
                                     @RequestBody UpdateUserRequest request) {
        UserEntity userEntity = userService.findOne(userId);
        if (userEntity == null) {
            throw new ResourceNotFoundException("User with id '" + userId + "' not found.");
        }

        if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
            userEntity.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null && !request.getLastName().isEmpty()) {
            userEntity.setLastName(request.getLastName());
        }

        if (request.getFired() != null) {
            userEntity.setFired(request.getFired());
        }

        if (request.getAccessLevelId() != null) {
            AccessLevelEntity accessLevelEntity = accessLevelService.findOne(request.getAccessLevelId());
            if (accessLevelEntity == null) {
                throw new ResourceNotFoundException("Access level with id '" + request.getAccessLevelId() + "' not found.");
            }

            userEntity.setAccessLevel(accessLevelEntity);
        }

        userEntity = userService.save(userEntity);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/") // TODO: test
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request,
                                                         @ModelAttribute UserEntity user) {
        if (user.getAccessLevel().getPriority() < 2) {
            throw new UnauthorizedAccessException("You are not allowed to perform this request.");
        }

        AccessLevelEntity accessLevel = accessLevelService.findOne(request.getAccessLevelId());
        if (accessLevel == null) {
            throw new ResourceNotFoundException("Access level with id '" + request.getAccessLevelId() + "' not found.");
        }

        UserEntity userEntity = userService.save(UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .fired(false)
                .accessLevel(accessLevel)
                .build());

        return ResponseEntity.ok(new CreateUserResponse(converter.convertToDto(userEntity)));
    }

    @ModelAttribute("user")
    public UserEntity getUser(HttpServletRequest servletRequest) {
        TokenPayload tokenPayload = (TokenPayload) servletRequest.getAttribute("tokenPayload");
        UserEntity user = userService.findOne(tokenPayload.getUserId());
        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }
}