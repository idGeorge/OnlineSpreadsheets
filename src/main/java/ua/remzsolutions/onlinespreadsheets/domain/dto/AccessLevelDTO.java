package ua.remzsolutions.onlinespreadsheets.domain.dto;

public class AccessLevelDTO {

    private Long id;

    private String name;

    private String description;

    private Integer priority;

    public AccessLevelDTO() {
    }

    public Long getId() {
        return id;
    }

    public AccessLevelDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccessLevelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AccessLevelDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public AccessLevelDTO setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public String toString() {
        return "AccessLevelDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}