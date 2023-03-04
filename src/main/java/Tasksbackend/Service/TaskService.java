package Tasksbackend.Service;

import Tasksbackend.Repository.TaskRepository;
import Tasksbackend.TaskDTO.Task;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addNewTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(UUID id){
        return taskRepository.findById(id);
    }
}
