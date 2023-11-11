package fr.ryan.task_management_api.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ryan.task_management_api.Task.Exception.NoTasksFoundException;
import fr.ryan.task_management_api.Task.Exception.TaskNotFoundException;

@Service
public final class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Fetch all tasks
     * @return List<Task>
     * @throws NoTasksFoundException
     */
    public List<Task> getAllTasks() {
        List<Task> tasks = this.taskRepository.findAll();
        if (tasks.isEmpty()) {
            throw new NoTasksFoundException();
        }
        return taskRepository.findAll();
    }

    /**
     * Fetch a task by its id
     * @param id
     * @return Task
     * @throws TaskNotFoundException
     */
    public Task getTaskById(int id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }
}
