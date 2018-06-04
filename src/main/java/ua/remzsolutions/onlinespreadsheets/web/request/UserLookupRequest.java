package ua.remzsolutions.onlinespreadsheets.web.request;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLookupRequest {

    private String username;
    private String firstName;
    private String lastName;
    private Boolean fired;
    private Long accessRoleId;
    private Integer page;
    private Integer pageSize;
}
