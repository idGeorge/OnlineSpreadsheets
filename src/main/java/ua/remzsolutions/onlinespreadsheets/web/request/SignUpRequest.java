package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.AccessLevelDTO;
import ua.remzsolutions.onlinespreadsheets.validation.constraints.UniqueUsername;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SignUpRequest extends AbstractRequest {

    @NotEmpty(message = "{field.required}")
    @Size(min = 6, message = "{username.size}")
    @UniqueUsername(value = "username", message = "{username.taken}")
    private String username;

    @NotEmpty(message = "{field.required}")
    @Size(min = 8, max = 32, message = "{password.size}")
    private String password;

    @NotEmpty(message = "{field.required}")
    private String confirmPassword;

    @NotEmpty(message = "{field.required}")
    private String firstName;

    @NotEmpty(message = "{field.required}")
    private String lastName;

    @NotEmpty
    private AccessLevelDTO[] roles;

    @AssertTrue
    public boolean isValid() {
        return confirmPassword.equals(password);
    }
}
