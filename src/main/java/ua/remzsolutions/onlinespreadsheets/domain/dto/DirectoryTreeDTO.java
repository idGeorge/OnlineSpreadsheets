package ua.remzsolutions.onlinespreadsheets.domain.dto;

public class DirectoryTreeDTO {

    private DirectoryDTO root;

    public DirectoryTreeDTO() {
    }

    public DirectoryDTO getRoot() {
        return root;
    }

    public DirectoryTreeDTO setRoot(DirectoryDTO root) {
        this.root = root;
        return this;
    }

    @Override
    public String toString() {
        return "DirectoryTreeDTO{" +
                "root=" + root +
                '}';
    }
}
