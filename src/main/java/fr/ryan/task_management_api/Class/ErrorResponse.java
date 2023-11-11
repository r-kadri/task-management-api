package fr.ryan.task_management_api.Class;

public final class ErrorResponse {
    private final String message;
    private final int code;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
