package ua.remzsolutions.onlinespreadsheets.web.validation.validators;

import ua.remzsolutions.onlinespreadsheets.domain.services.UserService;
import ua.remzsolutions.onlinespreadsheets.web.validation.constraints.UniqueUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserService userService;

    private String username;

    public UniqueUsernameValidator() {
    }

    public void initialize(UniqueUsername constraint) {
        this.username = constraint.value();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userService.findByUsername(username) == null;
    }

}