package ua.remzsolutions.onlinespreadsheets.web.request;

public class GetDocumentRequest extends AbstractRequest {

    private Long id;

    public GetDocumentRequest() {
    }

    public Long getId() {
        return id;
    }

    public GetDocumentRequest setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "GetDocumentRequest{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
