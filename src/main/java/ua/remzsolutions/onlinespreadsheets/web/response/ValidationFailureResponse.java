package ua.remzsolutions.onlinespreadsheets.web.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationFailureResponse extends AbstractResponse {

    private Map<String, List<String>> errors = new HashMap<>();

    private String errorMessage;

    public ValidationFailureResponse() {
    }


    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public ValidationFailureResponse setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ValidationFailureResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public void addValidationError(String field, String defaultMessage) {
        List<String> fieldErrors = errors.get(field);
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }

        fieldErrors.add(defaultMessage);
        errors.put(field, fieldErrors);
    }
}
