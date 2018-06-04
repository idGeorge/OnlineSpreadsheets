package ua.remzsolutions.onlinespreadsheets.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException extends RuntimeException {

    public UnauthorizedAccessException() {
        super("You aren't allowed to view this");
    }

    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
