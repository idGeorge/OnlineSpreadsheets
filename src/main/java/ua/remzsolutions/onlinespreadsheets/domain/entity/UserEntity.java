package ua.remzsolutions.onlinespreadsheets.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id", unique = true, nullable = false)
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "access_level")
    private AccessLevelEntity accessLevel;

    @Column(name = "fired")
    private boolean fired;


    public UserEntity() {
    }


    public String getId() {
        return id;
    }

    public UserEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccessLevelEntity getAccessLevel() {
        return accessLevel;
    }

    public UserEntity setAccessLevel(AccessLevelEntity accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    public boolean isFired() {
        return fired;
    }

    public UserEntity setFired(boolean fired) {
        this.fired = fired;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return fired == that.fired &&
                Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(accessLevel, that.accessLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, accessLevel, fired);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accessLevel=" + accessLevel +
                ", fired=" + fired +
                '}';
    }
}
