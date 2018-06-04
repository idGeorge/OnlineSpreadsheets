package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.DocumentDTO;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetDocumentResponse extends AbstractResponse {

    private DocumentDTO document;

}
