package ua.remzsolutions.onlinespreadsheets.domain.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessLevelDTO {

    private Long id;

    private String name;

    private String description;

    private Integer priority;

}