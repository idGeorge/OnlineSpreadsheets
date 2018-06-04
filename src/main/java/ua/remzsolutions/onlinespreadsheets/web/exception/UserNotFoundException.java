package ua.remzsolutions.onlinespreadsheets.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
