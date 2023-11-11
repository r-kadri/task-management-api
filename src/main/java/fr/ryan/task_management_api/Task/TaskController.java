package fr.ryan.task_management_api.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public List<Task> getAllTasks() {
        return this.taskService.getAllTasks();
    }

    @GetMapping(path = "/tasks/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable int id) {
        Task task = this.taskService.getTaskById(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
}
