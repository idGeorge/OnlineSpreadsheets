package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetUserResponse {

    private UserDTO user;

}
