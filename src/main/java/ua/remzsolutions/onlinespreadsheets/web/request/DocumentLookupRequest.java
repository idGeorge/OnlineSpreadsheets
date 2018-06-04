package ua.remzsolutions.onlinespreadsheets.web.request;

public class DocumentLookupRequest extends AbstractRequest {

    private String title;
    private String username;
    private Boolean archived;
    private Integer page;
    private Integer size;

    public DocumentLookupRequest() {
    }

    public DocumentLookupRequest(String title, String username, Boolean archived, Integer page, Integer size) {
        this.title = title;
        this.username = username;
        this.archived = archived;
        this.page = page;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public DocumentLookupRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DocumentLookupRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    public DocumentLookupRequest setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public DocumentLookupRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public DocumentLookupRequest setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return "DocumentLookupRequest{" +
                "username='" + username + '\'' +
                ", archived=" + archived +
                ", page=" + page +
                ", size=" + size +
                "} " + super.toString();
    }
}
