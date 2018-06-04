package ua.remzsolutions.onlinespreadsheets.util;

import ua.remzsolutions.onlinespreadsheets.web.response.ValidationFailureResponse;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;

public class ValidationFailureResponseBuilder {

    public static ValidationFailureResponse fromBindingErrors(Errors errors) {
        ValidationFailureResponse response = new ValidationFailureResponse();
        response.setErrorMessage("Validation failed. " + errors.getErrorCount() + " error(s)");

        List<FieldError> fieldErrorList = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            response.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return response;
    }
}