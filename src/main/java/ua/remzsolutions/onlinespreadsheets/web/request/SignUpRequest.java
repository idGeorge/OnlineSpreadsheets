package ua.remzsolutions.onlinespreadsheets.web.request;

import ua.remzsolutions.onlinespreadsheets.domain.dto.AccessLevelDTO;
import ua.remzsolutions.onlinespreadsheets.web.validation.constraints.UniqueUsername;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;

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

    public SignUpRequest() {
    }

    public String getUsername() {
        return username;
    }

    public SignUpRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SignUpRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public SignUpRequest setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SignUpRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SignUpRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccessLevelDTO[] getRoles() {
        return roles;
    }

    public SignUpRequest setRoles(AccessLevelDTO[] roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + Arrays.toString(roles) +
                "} " + super.toString();
    }
}
