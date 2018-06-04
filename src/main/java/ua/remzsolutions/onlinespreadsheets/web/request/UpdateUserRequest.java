package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private Boolean fired;
    private Long accessLevelId;

}
