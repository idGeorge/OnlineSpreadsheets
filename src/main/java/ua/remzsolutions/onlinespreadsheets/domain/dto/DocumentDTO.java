package ua.remzsolutions.onlinespreadsheets.domain.dto;

import java.util.Map;

public class DocumentDTO {

    private Long id;

    private String title;

    private Map<Integer, SheetDTO> sheets;

    private UserDTO author;

    private boolean archived;

    public DocumentDTO() {
    }

    public Long getId() {
        return id;
    }

    public DocumentDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DocumentDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Map<Integer, SheetDTO> getSheets() {
        return sheets;
    }

    public DocumentDTO setSheets(Map<Integer, SheetDTO> sheets) {
        this.sheets = sheets;
        return this;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public DocumentDTO setAuthor(UserDTO author) {
        this.author = author;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public DocumentDTO setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sheets=" + sheets +
                ", author=" + author +
                ", archived=" + archived +
                '}';
    }
}

