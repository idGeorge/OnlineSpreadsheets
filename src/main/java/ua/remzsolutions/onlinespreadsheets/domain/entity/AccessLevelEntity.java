package ua.remzsolutions.onlinespreadsheets.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "access_levels")
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


    public AccessLevelEntity() {
    }


    public Long getId() {
        return id;
    }

    public AccessLevelEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccessLevelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AccessLevelEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public AccessLevelEntity setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessLevelEntity that = (AccessLevelEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, priority);
    }

    @Override
    public String toString() {
        return "AccessLevelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority +'\'' +
                '}';
    }

    /**
     * Descending order. Where 1 > 2.
     * */
    @Override
    public int compareTo(AccessLevelEntity that) {
        return (that.priority - this.priority);
    }
}
