package ua.remzsolutions.onlinespreadsheets.web.request;

public class UpdateDocumentRequest extends AbstractRequest {

    private String title;
    private Boolean archived;
    private Long accessLevelId;


    public UpdateDocumentRequest() {
    }

    public UpdateDocumentRequest(String title, Boolean archived, Long accessLevelId) {
        this.title = title;
        this.archived = archived;
        this.accessLevelId = accessLevelId;
    }

    public String getTitle() {
        return title;
    }

    public UpdateDocumentRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    public UpdateDocumentRequest setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public UpdateDocumentRequest setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
        return this;
    }

    @Override
    public String toString() {
        return "UpdateDocumentRequest{" +
                "title='" + title + '\'' +
                ", archived=" + archived +
                ", accessRoleId=" + accessLevelId +
                "} " + super.toString();
    }
}
