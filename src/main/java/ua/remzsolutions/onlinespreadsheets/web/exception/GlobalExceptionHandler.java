package ua.remzsolutions.onlinespreadsheets.web.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.util.ValidationFailureResponseBuilder;
import ua.remzsolutions.onlinespreadsheets.web.response.ValidationFailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger();

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationFailureResponse invalidUserError(MethodArgumentNotValidException exception) {
        return ValidationFailureResponseBuilder.fromBindingErrors(exception.getBindingResult());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionRepresentation> userNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(exceptionRepresentation(ex), resolveAnnotatedResponseStatus(ex));
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionRepresentation> runtimeException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(exceptionRepresentation(ex), resolveAnnotatedResponseStatus(ex));
    }

    private HttpStatus resolveAnnotatedResponseStatus(Exception exception) {
        ResponseStatus annotation = findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private ExceptionRepresentation exceptionRepresentation(Exception e) {
        return new ExceptionRepresentation(e);
    }

}