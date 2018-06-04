package ua.remzsolutions.onlinespreadsheets.domain.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private AccessLevelDTO accessLevel;

}