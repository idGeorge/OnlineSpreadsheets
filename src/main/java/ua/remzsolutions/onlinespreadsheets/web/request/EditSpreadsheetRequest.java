package ua.remzsolutions.onlinespreadsheets.web.request;

import java.util.Objects;

public class EditSpreadsheetRequest {

    private Long id;
    private int row;
    private int col;
    private Object oldValue;
    private Object newValue;

    public EditSpreadsheetRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditSpreadsheetRequest that = (EditSpreadsheetRequest) o;
        return row == that.row &&
                col == that.col &&
                Objects.equals(id, that.id) &&
                Objects.equals(oldValue, that.oldValue) &&
                Objects.equals(newValue, that.newValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, row, col, oldValue, newValue);
    }

    @Override
    public String toString() {
        return "EditSpreadsheetRequest{" +
                "id=" + id +
                ", row=" + row +
                ", col=" + col +
                ", oldValue=" + oldValue +
                ", newValue=" + newValue +
                '}';
    }
}
