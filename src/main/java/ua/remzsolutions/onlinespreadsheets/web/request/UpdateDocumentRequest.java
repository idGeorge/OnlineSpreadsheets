package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateDocumentRequest extends AbstractRequest {

    private String title;
    private Boolean archived;
    private Long accessLevelId;

}
