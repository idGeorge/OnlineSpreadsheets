package ua.remzsolutions.onlinespreadsheets.web.request;

public class UpdateDirectoryRequest extends AbstractRequest {

    private Long parentDirectoryId;

    private String name;

    private Long accessLevelId;

    public UpdateDirectoryRequest() {
    }

    public Long getParentDirectoryId() {
        return parentDirectoryId;
    }

    public UpdateDirectoryRequest setParentDirectoryId(Long parentDirectoryId) {
        this.parentDirectoryId = parentDirectoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateDirectoryRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public UpdateDirectoryRequest setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
        return this;
    }

    @Override
    public String toString() {
        return "UpdateDirectoryRequest{" +
                "parentDirectoryId=" + parentDirectoryId +
                ", name='" + name + '\'' +
                ", accessLevelId=" + accessLevelId +
                "} " + super.toString();
    }
}
