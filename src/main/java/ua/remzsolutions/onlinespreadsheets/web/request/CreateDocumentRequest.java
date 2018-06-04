package ua.remzsolutions.onlinespreadsheets.web.request;

import javax.validation.constraints.NotEmpty;

public class CreateDocumentRequest extends AbstractRequest {

    @NotEmpty(message = "{field.required}")
    private String title;

    @NotEmpty(message = "{field.required}")
    private Long accessLevelId;

    public CreateDocumentRequest() {
    }

    public CreateDocumentRequest(String title, Long accessLevelId, Boolean archived) {
        this.title = title;
        this.accessLevelId = accessLevelId;
    }

    public String getTitle() {
        return title;
    }

    public CreateDocumentRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getAccessLevelId() {
        return accessLevelId;
    }

    public CreateDocumentRequest setAccessLevelId(Long accessLevelId) {
        this.accessLevelId = accessLevelId;
        return this;
    }

}
