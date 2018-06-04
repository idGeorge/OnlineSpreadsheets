package ua.remzsolutions.onlinespreadsheets.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Table(name = "directories")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DirectoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "directory_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_directory_id")
    private DirectoryEntity parentDirectory;

    @OneToMany(mappedBy = "parentDirectory")
    private Set<DirectoryEntity> subDirectories;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany
    @JoinTable(name = "directory_files",
            joinColumns = @JoinColumn(name = "directory_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id"))
    private Set<DocumentEntity> documents;

    @ManyToOne
    @JoinColumn(name = "access_level")
    private AccessLevelEntity accessLevel;

}
