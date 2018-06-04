package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryTreeDTO;

public class DirectoryTreeResponse extends AbstractResponse {

    private DirectoryTreeDTO tree;

    public DirectoryTreeResponse(DirectoryTreeDTO tree) {
        this.tree = tree;
    }

    public DirectoryTreeDTO getTree() {
        return tree;
    }

    public DirectoryTreeResponse setTree(DirectoryTreeDTO tree) {
        this.tree = tree;
        return this;
    }
}
