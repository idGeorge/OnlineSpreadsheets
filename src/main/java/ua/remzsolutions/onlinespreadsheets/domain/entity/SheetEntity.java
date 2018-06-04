package ua.remzsolutions.onlinespreadsheets.domain.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Entity
@Builder
@Table(name = "sheets")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sheet_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content")
    private String content;


    public void removeRow(int index) {
        List<List<Object>> jsonArray = this.getArray();
        jsonArray.remove(index);
        fromArrayToJson(jsonArray);
    }

    public void insertEmptyRow(int index) {
        List<List<Object>> jsonArray = this.getArray();
        if (index > jsonArray.size()) {
            throw new IndexOutOfBoundsException("Invalid 'index' value = " + index);
        }

        LinkedList<Object> linkedList = new LinkedList<>();
        for (int i = 0; i < jsonArray.get(0).size(); i++) {
            linkedList.add(null);
        }

        jsonArray.add(index, linkedList);
        fromArrayToJson(jsonArray);
    }

    public void insertEmptyCol(int index) {
        List<List<Object>> jsonArray = this.getArray();
        if (index > jsonArray.get(0).size() || index < 0) {
            throw new IndexOutOfBoundsException("Invalid 'index' value =  " + index);
        }

        for (List<Object> row : jsonArray) {
            row.add(index, null);
        }
        fromArrayToJson(jsonArray);
    }

    public void removeCol(int index) {
        List<List<Object>> jsonArray = this.getArray();
        if (index > jsonArray.get(0).size() || index < 0) {
            throw new IndexOutOfBoundsException("Invalid 'index' value =  " + index);
        }

        for (List<Object> row: jsonArray) {
            row.remove(index);
        }
        fromArrayToJson(jsonArray);
    }

    public void set(int row, int col, Object value) {
        List<List<Object>> jsonArray = this.getArray();
        checkBounds(row, col);
        jsonArray.get(row).set(col, value);
        fromArrayToJson(jsonArray);
    }

    public void clear(int row, int col) {
        List<List<Object>> jsonArray = this.getArray();
        checkBounds(row, col);
        jsonArray.get(row).set(col, null);
        fromArrayToJson(jsonArray);
    }

    private void checkBounds(int row, int col) {
        List<List<Object>> jsonArray = this.getArray();
        if (row > jsonArray.size() || col > jsonArray.get(0).size()
                || row < 0 || col < 0) {
            throw new IllegalArgumentException("row & col values are out of bounds");
        }
    }

    private List<List<Object>> fromJsonToArray(String content) {
        List<List<Object>> jsonArray = null;
        try {
            jsonArray =  new ObjectMapper().readValue(content, LinkedList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    private void fromArrayToJson(List<List<Object>> array) {
        try {
            this.content = new ObjectMapper().writeValueAsString(array);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<List<Object>> getArray() {
        return fromJsonToArray(content);
    }

}