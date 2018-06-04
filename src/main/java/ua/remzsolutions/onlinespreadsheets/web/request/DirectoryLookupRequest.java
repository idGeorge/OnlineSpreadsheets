package ua.remzsolutions.onlinespreadsheets.web.request;


public class DirectoryLookupRequest {

    private Long parentDirectoryId;
    private String name;
    private Integer page;
    private Integer pageSize;

    public DirectoryLookupRequest() {
    }

    public Long getParentDirectoryId() {
        return parentDirectoryId;
    }

    public DirectoryLookupRequest setParentDirectoryId(Long parentDirectoryId) {
        this.parentDirectoryId = parentDirectoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public DirectoryLookupRequest setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public DirectoryLookupRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public DirectoryLookupRequest setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public String toString() {
        return "DirectoryLookupRequest{" +
                "parentDirectoryId=" + parentDirectoryId +
                ", name='" + name + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
