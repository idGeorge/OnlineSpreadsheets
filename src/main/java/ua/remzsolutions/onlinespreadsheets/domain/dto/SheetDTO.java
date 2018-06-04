package ua.remzsolutions.onlinespreadsheets.domain.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SheetDTO {

    private Long id;

    private String title;

    private String content;

}
