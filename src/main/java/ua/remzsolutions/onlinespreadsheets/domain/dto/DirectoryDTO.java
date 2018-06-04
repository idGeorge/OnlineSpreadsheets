package ua.remzsolutions.onlinespreadsheets.domain.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectoryDTO {

    private Long id;

    private String name;

    private Set<DocumentDTO> documents;

    private Set<DirectoryDTO> subDirectories;

}