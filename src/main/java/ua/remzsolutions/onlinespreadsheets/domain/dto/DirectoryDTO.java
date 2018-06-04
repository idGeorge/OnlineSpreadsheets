package ua.remzsolutions.onlinespreadsheets.domain.dto;

import java.util.Objects;
import java.util.Set;

public class DirectoryDTO {

    private Long id;

    private String name;

    private Set<DocumentDTO> documents;

    private Set<DirectoryDTO> subDirectories;

    public DirectoryDTO() {
    }


    public Long getId() {
        return id;
    }

    public DirectoryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DirectoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<DocumentDTO> getDocuments() {
        return documents;
    }

    public DirectoryDTO setDocuments(Set<DocumentDTO> documents) {
        this.documents = documents;
        return this;
    }

    public Set<DirectoryDTO> getSubDirectories() {
        return subDirectories;
    }

    public DirectoryDTO setSubDirectories(Set<DirectoryDTO> subDirectories) {
        this.subDirectories = subDirectories;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectoryDTO that = (DirectoryDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(documents, that.documents) &&
                Objects.equals(subDirectories, that.subDirectories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, documents, subDirectories);
    }

    @Override
    public String toString() {
        return "DirectoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documents=" + documents +
                ", subDirectories=" + subDirectories +
                '}';
    }
}