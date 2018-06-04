package ua.remzsolutions.onlinespreadsheets.web.response;

public class LoginResponse extends AbstractResponse{

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
