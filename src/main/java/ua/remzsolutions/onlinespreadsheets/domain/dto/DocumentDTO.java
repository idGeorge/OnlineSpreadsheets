package ua.remzsolutions.onlinespreadsheets.domain.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentDTO {

    private Long id;

    private String title;

    private Map<Integer, SheetDTO> sheets;

    private UserDTO author;

    private boolean archived;

}

