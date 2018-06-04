package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateDirectoryResponse {

    private DirectoryDTO directoryDTO;
}
