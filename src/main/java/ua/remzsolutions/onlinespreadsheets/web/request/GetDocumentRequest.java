package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetDocumentRequest extends AbstractRequest {

    private Long id;
}
