package ua.remzsolutions.onlinespreadsheets.web.request;

public class RoutingData {

    private String userId;

    public RoutingData(String userId) {
        this.userId = userId;
    }

    public RoutingData() {
    }

    public String getUserId() {
        return userId;
    }

    public RoutingData setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return "RoutingData{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
