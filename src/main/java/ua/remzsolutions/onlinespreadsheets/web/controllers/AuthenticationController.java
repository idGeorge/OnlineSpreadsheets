package ua.remzsolutions.onlinespreadsheets.web.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import ua.remzsolutions.onlinespreadsheets.security.service.SecurityService;
import ua.remzsolutions.onlinespreadsheets.util.JwtTokenUtil;
import ua.remzsolutions.onlinespreadsheets.web.exception.UserNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.request.LoginRequest;
import ua.remzsolutions.onlinespreadsheets.web.request.SignUpRequest;
import ua.remzsolutions.onlinespreadsheets.web.response.LoginResponse;

import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LogManager.getLogger();

    private final UserService userService;
    private final SecurityService securityService;
    private final JwtTokenUtil tokenUtil;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public AuthenticationController(UserService userService, SecurityService securityService, JwtTokenUtil tokenUtil, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.securityService = securityService;
        this.tokenUtil = tokenUtil;
        this.encoder = encoder;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            throw new UserNotFoundException();
        }

        securityService.authenticate(username, password);
        String token = tokenUtil.generateToken(userEntity.getId());

        return ResponseEntity.ok().body(new LoginResponse(token));
    }

    @PostMapping(value = "/register")
    public void register(@Valid @RequestBody SignUpRequest request) {

        UserEntity userEntity = UserEntity.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getFirstName())
                .fired(false)
                .build();

        userService.save(userEntity);
    }
}
