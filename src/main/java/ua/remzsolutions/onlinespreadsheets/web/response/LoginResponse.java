package ua.remzsolutions.onlinespreadsheets.web.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponse extends AbstractResponse{

    private String token;

}
