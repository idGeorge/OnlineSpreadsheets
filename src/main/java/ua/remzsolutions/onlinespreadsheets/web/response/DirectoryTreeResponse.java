package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryTreeDTO;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectoryTreeResponse extends AbstractResponse {

    private DirectoryTreeDTO tree;

}
