package ua.remzsolutions.onlinespreadsheets.web.request;

public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private Boolean fired;
    private Long accessLevelId;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String firstName,
                             String lastName,
                             Boolean fired,
                             Long accessLevelId,
                             String password,
                             String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fired = fired;
        this.accessLevelId = accessLevelId;
    }

    public String getFirstName() {
        return firstName;
    }

    public UpdateUserRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateUserRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getFired() {
        return fired;
    }

    public UpdateUserRequest setFired(Boolean fired) {
        this.fired = fired;
        return this;
    }

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public UpdateUserRequest setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
        return this;
    }


    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fired=" + fired +
                ", accessLevelId=" + accessLevelId +
                '}';
    }
}
