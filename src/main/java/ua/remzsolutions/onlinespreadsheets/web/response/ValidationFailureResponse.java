package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidationFailureResponse extends AbstractResponse {

    private Map<String, List<String>> errors = new HashMap<>();

    private String errorMessage;


    public void addValidationError(String field, String defaultMessage) {
        List<String> fieldErrors = errors.get(field);
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }

        fieldErrors.add(defaultMessage);
        errors.put(field, fieldErrors);
    }
}
