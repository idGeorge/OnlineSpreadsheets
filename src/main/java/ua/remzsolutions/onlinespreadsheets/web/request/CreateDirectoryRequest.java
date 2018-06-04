package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateDirectoryRequest {

    @NotEmpty(message = "{field.required}")
    private String name;

    @NotEmpty(message = "{field.required}")
    private Long accessLevelId;

    @NotEmpty(message = "{field.required}")
    private Long parenDirectoryId;

}
