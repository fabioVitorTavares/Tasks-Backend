package Tasksbackend.Service;

import Tasksbackend.Repository.TaskRepository;
import Tasksbackend.TaskDTO.Task;
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

        oldTask.get().setDescription(task.getDescription());

        oldTask.get().setDate(task.getDate());

        taskRepository.save(oldTask.get());
            
        return oldTask.get();
    }

    public String deleteTask(UUID id){
        Boolean existTask = taskRepository.existsById(id);
        if(existTask){
            taskRepository.deleteById(id);
            return "Tarefa excluída com sucesso!";
        }
        return "Tarefa não encontrada!";
    }
}
