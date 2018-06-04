package ua.remzsolutions.onlinespreadsheets.domain.dto;

public class UserDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private AccessLevelDTO accessLevel;


    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccessLevelDTO getAccessLevel() {
        return accessLevel;
    }

    public UserDTO setAccessLevel(AccessLevelDTO accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }
}