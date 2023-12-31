package fr.ryan.task_management_api.Task.Exception;

public class TaskNotFoundException extends RuntimeException {
    private int id;

    public TaskNotFoundException(int id) {
        super("Task with id " + id + " not found");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
