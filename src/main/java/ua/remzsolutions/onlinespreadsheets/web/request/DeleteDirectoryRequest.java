package ua.remzsolutions.onlinespreadsheets.web.request;

public class DeleteDirectoryRequest extends AbstractRequest {

    private Long id;

    public DeleteDirectoryRequest() {
    }

    public Long getId() {
        return id;
    }

    public DeleteDirectoryRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
