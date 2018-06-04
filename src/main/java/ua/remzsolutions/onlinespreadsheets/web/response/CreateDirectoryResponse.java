package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;

public class CreateDirectoryResponse {

    private DirectoryDTO directoryDTO;

    public CreateDirectoryResponse(DirectoryDTO directoryDTO) {
        this.directoryDTO = directoryDTO;
    }

    public DirectoryDTO getDirectoryDTO() {
        return directoryDTO;
    }

    public CreateDirectoryResponse setDirectoryDTO(DirectoryDTO directoryDTO) {
        this.directoryDTO = directoryDTO;
        return this;
    }
}
