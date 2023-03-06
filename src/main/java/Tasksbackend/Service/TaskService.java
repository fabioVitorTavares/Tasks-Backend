package Tasksbackend.Service;

import Tasksbackend.Repository.TaskRepository;
import Tasksbackend.TaskDTO.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addNewTask(Optional<Task> task){
        return taskRepository.save(task.get());
    }

    public Optional<Task> getTaskById(UUID id){
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task saveUpdateTask(Task task){
        
        Optional<Task> oldTask = taskRepository.findById(task.getId());
        
        BeanUtils.copyProperties(task, oldTask);
            
        return taskRepository.save(oldTask.get());
    }
}
