package fr.ryan.task_management_api.Task.Exception;

public class NoTasksFoundException extends RuntimeException {
    public NoTasksFoundException() {
        super("No tasks found");
    }
}
