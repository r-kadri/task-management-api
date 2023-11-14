package fr.ryan.task_management_api.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import fr.ryan.task_management_api.Task.Exception.InvalidTaskException;
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

    /**
     * Add a task
     * @param task
     * @return Task
     * @throws InvalidTaskException
     */
    public Task addTask(Task task) {
        if(task.getStatus() == null) {
            task.setStatus(TaskStatusEnum.IN_PROGRESS);
        }
        try {
            this.taskRepository.save(task);
        } catch (DataIntegrityViolationException ex) {
            throw ex.getMessage().contains("not-null")
                ? new InvalidTaskException("Label is required")
                : new InvalidTaskException();
        }
        return task;
    }

    /**
     * Update a task status
     * @param id
     * @param status
     * @return Task
     * @throws TaskNotFoundException
     */
    public Task updateTaskStatus(int id, TaskStatusEnum status) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.setStatus(status);
        return this.taskRepository.save(task);
    }

    /**
     * Delete a task
     * @param id
     * @return boolean
     * @throws TaskNotFoundException
     */
    public boolean deleteTask(int id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        this.taskRepository.delete(task);
        return true;
    }
}
