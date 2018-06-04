package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;
import org.springframework.data.domain.Page;

public class DirectoryLookupResponse {

    private Page<DirectoryDTO> page;

    public DirectoryLookupResponse() {
    }

    public DirectoryLookupResponse(Page<DirectoryDTO> page) {
        this.page = page;
    }

    public Page<DirectoryDTO> getPage() {
        return page;
    }

    public DirectoryLookupResponse setPage(Page<DirectoryDTO> page) {
        this.page = page;
        return this;
    }
}
