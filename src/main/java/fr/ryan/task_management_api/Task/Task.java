package fr.ryan.task_management_api.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public final class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatusEnum getStatus() {
        return this.status;
    }

    public void setLabel(String label) {
        this.label = label.trim();
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }
}
