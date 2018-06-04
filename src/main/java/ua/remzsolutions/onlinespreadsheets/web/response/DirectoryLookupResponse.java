package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DirectoryDTO;
import org.springframework.data.domain.Page;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectoryLookupResponse {

    private Page<DirectoryDTO> page;

}
