package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EditSpreadsheetRequest {

    private Long id;
    private int row;
    private int col;
    private Object oldValue;
    private Object newValue;

}
