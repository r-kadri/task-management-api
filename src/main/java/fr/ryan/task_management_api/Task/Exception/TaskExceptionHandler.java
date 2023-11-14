package fr.ryan.task_management_api.Task.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.ryan.task_management_api.Class.Response;

@ControllerAdvice
@RestController
public class TaskExceptionHandler {
    @ExceptionHandler(NoTasksFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleNoTasksFoundException(NoTasksFoundException ex) {
        Response response = new Response("No tasks found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> handleTaskNotFoundException(TaskNotFoundException ex) {
        Response response = new Response("Task with id " + ex.getId() + " not found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidTaskException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response> handleInvalidTaskException(InvalidTaskException ex) {
        Response response = new Response(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
    }
}
