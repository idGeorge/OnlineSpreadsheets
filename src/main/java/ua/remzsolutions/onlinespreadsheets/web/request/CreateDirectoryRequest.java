package ua.remzsolutions.onlinespreadsheets.web.request;

import javax.validation.constraints.NotEmpty;

public class CreateDirectoryRequest {


    @NotEmpty(message = "{field.required}")
    private String name;

    @NotEmpty(message = "{field.required}")
    private Long accessLevelId;

    @NotEmpty(message = "{field.required}")
    private Long parenDirectoryId;

    public CreateDirectoryRequest() {
    }

    public String getName() {
        return name;
    }

    public CreateDirectoryRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public CreateDirectoryRequest setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
        return this;
    }

    public Long getParenDirectoryId() {
        return parenDirectoryId;
    }

    public CreateDirectoryRequest setParenDirectoryId(Long parenDirectoryId) {
        this.parenDirectoryId = parenDirectoryId;
        return this;
    }

    @Override
    public String toString() {
        return "CreateDirectoryRequest{" +
                "name='" + name + '\'' +
                ", accessLevelId=" + accessLevelId +
                ", parenDirectoryId=" + parenDirectoryId +
                '}';
    }
}
