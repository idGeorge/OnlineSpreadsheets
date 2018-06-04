package ua.remzsolutions.onlinespreadsheets.domain.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Builder
@Table(name = "documents")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "documents_sheets",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "sheet_id"))
    private Map<Integer, SheetEntity> sheets;

    @ManyToOne
    @JoinColumn(name = "access_level")
    private AccessLevelEntity accessLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @Column(name = "archived")
    private boolean archived;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;

}
