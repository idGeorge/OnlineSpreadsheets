package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;

public class GetDocumentResponse extends AbstractResponse {

    private DocumentDTO document;

    public GetDocumentResponse() {
    }

    public GetDocumentResponse(DocumentDTO document) {
        this.document = document;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public GetDocumentResponse setDocument(DocumentDTO document) {
        this.document = document;
        return this;
    }

    @Override
    public String toString() {
        return "GetDocumentResponse{" +
                "document=" + document +
                '}';
    }
}
