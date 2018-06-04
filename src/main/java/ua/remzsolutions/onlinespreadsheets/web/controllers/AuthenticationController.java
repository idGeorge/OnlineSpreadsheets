package ua.remzsolutions.onlinespreadsheets.web.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import ua.remzsolutions.onlinespreadsheets.security.service.SecurityService;
import ua.remzsolutions.onlinespreadsheets.util.JwtTokenUtil;
import ua.remzsolutions.onlinespreadsheets.web.exception.UserNotFoundException;
import ua.remzsolutions.onlinespreadsheets.web.request.LoginRequest;
import ua.remzsolutions.onlinespreadsheets.web.request.SignUpRequest;
import ua.remzsolutions.onlinespreadsheets.web.response.LoginResponse;
import ua.remzsolutions.onlinespreadsheets.web.response.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        UserEntity userEntity = userService.findByUsername(username);
        if (userEntity == null) {
            throw new UserNotFoundException();
        }

        securityService.autoLogin(username, password);
        String token = tokenUtil.generateToken(userEntity.getId());

        return ResponseEntity.ok().body(new LoginResponse(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<SignUpResponse> register(@Valid @RequestBody SignUpRequest request) {
        UserEntity userEntity = new UserEntity()
                .setUsername(request.getUsername())
                .setPassword(encoder.encode(request.getPassword()))
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName());

        userService.save(userEntity);

        return ResponseEntity.ok().body(new SignUpResponse());
    }
}
