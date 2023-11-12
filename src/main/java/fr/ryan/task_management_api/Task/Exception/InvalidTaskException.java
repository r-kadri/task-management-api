package fr.ryan.task_management_api.Task.Exception;

public class InvalidTaskException extends RuntimeException {
    private String message;

    public InvalidTaskException(String message) {
        super(message);
        this.message = message;
    }

    public InvalidTaskException() {
        this("Invalid task");
    }

    public String getMessage() {
        return this.message;
    }
}
