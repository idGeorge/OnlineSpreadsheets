package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;

public class GetUserResponse {

    private UserDTO user;

    public GetUserResponse(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public GetUserResponse setUser(UserDTO user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "GetUserResponse{" +
                "user=" + user +
                '}';
    }
}
