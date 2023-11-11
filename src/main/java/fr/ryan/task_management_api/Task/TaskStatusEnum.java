package fr.ryan.task_management_api.Task;

public enum TaskStatusEnum {
    
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String status;

    private TaskStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return this.getStatus();
    }
}
