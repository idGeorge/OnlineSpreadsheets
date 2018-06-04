package ua.remzsolutions.onlinespreadsheets.web.request;

import javax.validation.constraints.NotEmpty;

public class UserLookupRequest {

    private String username;
    private String firstName;
    private String lastName;
    private Boolean fired;
    private Long accessRoleId;
    @NotEmpty
    private Integer page;
    @NotEmpty
    private Integer pageSize;

    public UserLookupRequest() {
    }

    public UserLookupRequest(String username, String firstName, String lastName, Boolean fired, Long accessRoleId, Integer page, Integer pageSize) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fired = fired;
        this.accessRoleId = accessRoleId;
        this.page = page;
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public UserLookupRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserLookupRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserLookupRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getFired() {
        return fired;
    }

    public UserLookupRequest setFired(Boolean fired) {
        this.fired = fired;
        return this;
    }

    public Long getAccessRoleId() {
        return accessRoleId;
    }

    public UserLookupRequest setAccessRoleId(Long accessRoleId) {
        this.accessRoleId = accessRoleId;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public UserLookupRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public UserLookupRequest setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public String toString() {
        return "UserLookupRequest{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fired=" + fired +
                ", accessRoleId=" + accessRoleId +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
