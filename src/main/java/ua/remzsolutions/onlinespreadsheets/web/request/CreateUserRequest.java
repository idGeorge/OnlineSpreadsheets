package ua.remzsolutions.onlinespreadsheets.web.request;

import ua.remzsolutions.onlinespreadsheets.web.validation.constraints.UniqueUsername;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateUserRequest {

    @NotEmpty(message = "{field.required}")
    @Size(min = 6, message = "{username.size}")
    @UniqueUsername(value = "username", message = "{username.taken}")
    private String username;

    @NotEmpty(message = "{field.required}")

    private String firstName;
    @NotEmpty(message = "{field.required}")

    @NotEmpty(message = "{field.required}")
    private String lastName;

    @NotEmpty(message = "{field.required}")
    @Size(min = 8, max = 32, message = "{password.size}")
    private String password;

    @NotEmpty(message = "{field.required}")
    private String confirmPassword;

    @NotEmpty(message = "{field.required}")
    private Long accessLevelId;

    @AssertTrue(message = "{password.confirmation}")
    public boolean isValid() {
        return confirmPassword.equals(password);
    }

    public CreateUserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public CreateUserRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateUserRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateUserRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public CreateUserRequest setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public CreateUserRequest setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
        return this;
    }
}
