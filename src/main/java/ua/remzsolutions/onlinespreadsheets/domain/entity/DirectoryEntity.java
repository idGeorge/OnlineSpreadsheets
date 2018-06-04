package ua.remzsolutions.onlinespreadsheets.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "directories")
public class DirectoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "directory_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_directory_id")
    private DirectoryEntity parentDirectory;

    @OneToMany(mappedBy = "parentDirectory")
    private Set<DirectoryEntity> subDirectories;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany
    @JoinTable(name = "directory_files",
            joinColumns = @JoinColumn(name = "directory_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id"))
    private Set<DocumentEntity> documents;

    @ManyToOne
    @JoinColumn(name = "access_level")
    private AccessLevelEntity accessLevel;


    public DirectoryEntity() {
    }


    public Long getId() {
        return id;
    }

    public DirectoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public DirectoryEntity getParentDirectory() {
        return parentDirectory;
    }

    public DirectoryEntity setParentDirectory(DirectoryEntity parentDirectory) {
        this.parentDirectory = parentDirectory;
        return this;
    }

    public Set<DirectoryEntity> getSubDirectories() {
        return subDirectories;
    }

    public DirectoryEntity setSubDirectories(Set<DirectoryEntity> subDirectories) {
        this.subDirectories = subDirectories;
        return this;
    }

    public String getName() {
        return name;
    }

    public DirectoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public DirectoryEntity setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Set<DocumentEntity> getDocuments() {
        return documents;
    }

    public DirectoryEntity setDocuments(Set<DocumentEntity> documents) {
        this.documents = documents;
        return this;
    }

    public AccessLevelEntity getAccessLevel() {
        return accessLevel;
    }

    public DirectoryEntity setAccessLevel(AccessLevelEntity accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectoryEntity directoryEntity = (DirectoryEntity) o;
        return Objects.equals(id, directoryEntity.id) &&
                Objects.equals(dateCreated, directoryEntity.dateCreated) &&
                Objects.equals(accessLevel, directoryEntity.accessLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreated, accessLevel);
    }

    @Override
    public String toString() {
        return "DirectoryEntity{" +
                "id=" + id +
                ", parentDirectory=" + parentDirectory +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", documents=" + documents +
                ", accessLevel=" + accessLevel +
                '}';
    }
}
