package ua.remzsolutions.onlinespreadsheets.web.request;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectoryLookupRequest {

    private Long parentDirectoryId;
    private String name;
    private Integer page;
    private Integer pageSize;
}
