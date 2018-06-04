package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;

public class CreateDocumentResponse extends AbstractResponse {

    private DocumentDTO document;

    public CreateDocumentResponse() {
    }

    public CreateDocumentResponse(DocumentDTO document) {
        this.document = document;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public CreateDocumentResponse setDocument(DocumentDTO document) {
        this.document = document;
        return this;
    }
}
