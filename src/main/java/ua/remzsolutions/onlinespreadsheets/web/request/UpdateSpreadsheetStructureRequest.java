package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateSpreadsheetStructureRequest {

    @NotNull
    private Long id;
    @NotEmpty
    private String operation;
    private int col;
    private int row;

}
