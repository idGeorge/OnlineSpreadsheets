package ua.remzsolutions.onlinespreadsheets.security.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.domain.repository.UserRepository;
import ua.remzsolutions.onlinespreadsheets.domain.entity.UserEntity;
import ua.remzsolutions.onlinespreadsheets.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger();

    private final UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        logger.info("Loading user with username = '{}'", username);
        UserEntity userEntity = repository.findByUsernameEquals(username);

        if (userEntity == null) {
            logger.info("User with username = '{}' not found", username);
            throw new UserNotFoundException();
        } else {
            return new User(userEntity.getUsername(), userEntity.getPassword(), new HashSet<>());
        }
    }
}
