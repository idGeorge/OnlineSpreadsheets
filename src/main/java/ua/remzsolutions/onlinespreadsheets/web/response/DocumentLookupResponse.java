package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;
import org.springframework.data.domain.Page;

public class DocumentLookupResponse extends AbstractResponse {

    private Page<DocumentDTO> page;

    public DocumentLookupResponse() {
    }

    public DocumentLookupResponse(Page<DocumentDTO> page) {
        this.page = page;
    }

    public Page<DocumentDTO> getPage() {
        return page;
    }

    public DocumentLookupResponse setPage(Page<DocumentDTO> page) {
        this.page = page;
        return this;
    }

    @Override
    public String toString() {
        return "DocumentLookupResponse{" +
                "page=" + page +
                '}';
    }
}
