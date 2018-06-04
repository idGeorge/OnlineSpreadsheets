package ua.remzsolutions.onlinespreadsheets.security.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class SecurityServiceImpl implements SecurityService {

    private static final Logger logger = LogManager.getLogger();

    private final AuthenticationManager authenticationManager;

    @Autowired
    public SecurityServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication authenticate(String username, String password) {
        logger.info("Trying to log in user '{}'", username);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("ROLE_USER")));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }
}
