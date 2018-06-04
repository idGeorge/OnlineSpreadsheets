package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;
import org.springframework.data.domain.Page;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentLookupResponse extends AbstractResponse {

    private Page<DocumentDTO> page;

}
