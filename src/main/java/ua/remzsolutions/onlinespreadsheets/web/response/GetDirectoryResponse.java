package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;

public class GetDirectoryResponse extends AbstractResponse {

    private DirectoryDTO directory;

    public GetDirectoryResponse(DirectoryDTO directory) {
        this.directory = directory;
    }

    public DirectoryDTO getDirectory() {
        return directory;
    }

    public GetDirectoryResponse setDirectory(DirectoryDTO directory) {
        this.directory = directory;
        return this;
    }
}
