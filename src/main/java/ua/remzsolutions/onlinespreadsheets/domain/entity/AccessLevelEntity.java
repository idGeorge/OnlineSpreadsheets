package ua.remzsolutions.onlinespreadsheets.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity@Builder
@Table(name = "access_levels")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccessLevelEntity implements Comparable<AccessLevelEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "access_level_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "priority", unique = true)
    private Integer priority;

    /**
     * Descending order. Where 1 > 2.
     * */
    @Override
    public int compareTo(AccessLevelEntity that) {
        return (that.priority - this.priority);
    }
}
