package ua.remzsolutions.onlinespreadsheets.web.exception;

public class ExceptionRepresentation {

    private String message;

    public ExceptionRepresentation(Exception exception) {
        this.message = exception.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
