package ua.remzsolutions.onlinespreadsheets.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "documents")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "documents_sheets",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "sheet_id"))
    private Map<Integer, SheetEntity> sheets;

    @ManyToOne
    @JoinColumn(name = "access_level")
    private AccessLevelEntity accessLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @Column(name = "archived")
    private boolean archived;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;


    public DocumentEntity() {
    }


    // TODO: Modify document methods

    public Long getId() {
        return id;
    }

    public DocumentEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public DocumentEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public DocumentEntity setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Map<Integer, SheetEntity> getSheets() {
        return sheets;
    }

    public DocumentEntity setSheets(Map<Integer, SheetEntity> sheets) {
        this.sheets = sheets;
        return this;
    }

    public AccessLevelEntity getAccessLevel() {
        return accessLevel;
    }

    public DocumentEntity setAccessLevel(AccessLevelEntity accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public DocumentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public DocumentEntity setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public DocumentEntity setDateModified(Date dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentEntity documentEntity = (DocumentEntity) o;
        return Objects.equals(id, documentEntity.id) &&
                Objects.equals(title, documentEntity.title) &&
                Objects.equals(dateCreated, documentEntity.dateCreated) &&
                Objects.equals(sheets, documentEntity.sheets) &&
                Objects.equals(accessLevel, documentEntity.accessLevel) &&
                Objects.equals(author, documentEntity.author) &&
                Objects.equals(archived, documentEntity.archived) &&
                Objects.equals(dateModified, documentEntity.dateModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dateCreated, sheets, accessLevel, author, archived, dateModified);
    }

    @Override
    public String toString() {
        return "DocumentEntity{" +
                "id=" + id +
                ", title=" + title +
                ", dateCreated=" + dateCreated +
                ", sheets=" + sheets +
                ", accessLevel=" + accessLevel +
                ", author=" + author +
                ", archived=" + archived +
                ", dateModified=" + dateModified +
                '}';
    }
}
