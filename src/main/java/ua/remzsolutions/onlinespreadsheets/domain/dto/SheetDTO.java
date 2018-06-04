package ua.remzsolutions.onlinespreadsheets.domain.dto;

public class SheetDTO {

    private Long id;

    private String title;

    private String content;

    public SheetDTO() {
    }

    public Long getId() {
        return id;
    }

    public SheetDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SheetDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SheetDTO setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return "SheetDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
