package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateDocumentRequest extends AbstractRequest {

    @NotEmpty(message = "{field.required}")
    private String title;

    @NotEmpty(message = "{field.required}")
    private Long accessLevelId;

}
