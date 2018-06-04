package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;
import org.springframework.data.domain.Page;
import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLookupResponse {

    private Page<UserDTO> page;

}
