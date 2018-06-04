package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;

public class CreateUserResponse {

    private UserDTO user;

    public CreateUserResponse() {
    }

    public CreateUserResponse(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public CreateUserResponse setUser(UserDTO user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "CreateUserResponse{" +
                "user=" + user +
                '}';
    }
}
