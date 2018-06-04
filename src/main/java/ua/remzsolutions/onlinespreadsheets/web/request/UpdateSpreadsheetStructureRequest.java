package ua.remzsolutions.onlinespreadsheets.web.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateSpreadsheetStructureRequest {
    @NotNull
    private Long id;
    @NotEmpty
    private String operation;

    private int col;
    private int row;

    public UpdateSpreadsheetStructureRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
