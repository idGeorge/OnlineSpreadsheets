package ua.remzsolutions.onlinespreadsheets.web.request;

public class GetDirectoryRequest extends AbstractRequest {

    private Long id;

    public GetDirectoryRequest() {
    }

    public Long getId() {
        return id;
    }

    public GetDirectoryRequest setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "GetDirectoryRequest{" +
                "id=" + id +
                '}';
    }
}
