package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateDirectoryRequest extends AbstractRequest {

    private Long parentDirectoryId;

    private String name;

    private Long accessLevelId;
}
