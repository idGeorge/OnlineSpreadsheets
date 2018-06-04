package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentLookupRequest extends AbstractRequest {

    private String title;
    private String username;
    private Boolean archived;
    private Integer page;
    private Integer size;
}
