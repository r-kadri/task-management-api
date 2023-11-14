package fr.ryan.task_management_api.Task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ryan.task_management_api.Class.Response;

@RestController
public final class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> tasks = this.taskService.getAllTasks();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @GetMapping(path = "/tasks/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id) {
        Task task = this.taskService.getTaskById(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @PostMapping(path = "/tasks/add")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        Task newTask = this.taskService.addTask(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }

    @PutMapping(path = "/tasks/{id}/updateStatus")
    public ResponseEntity<?> updateTaskStatus(@PathVariable  int id, @RequestBody TaskStatusUpdateRequest request) {
        Task updatedTask = this.taskService.updateTaskStatus(id, request.getStatus());
        return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping(path = "/tasks/{id}/delete")
    public ResponseEntity<?> deleteTask(@PathVariable  int id) {
        this.taskService.deleteTask(id);
        return new ResponseEntity<Response>(new Response("Task deleted", 200), HttpStatus.OK);
    }
}
