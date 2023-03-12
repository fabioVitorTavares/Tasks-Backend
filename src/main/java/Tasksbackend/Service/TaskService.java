package Tasksbackend.Service;

import Tasksbackend.Repository.TaskRepository;
import Tasksbackend.Model.Task;
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

    public String saveTask(Task task){

        taskRepository.save(task);

        return "Tarefa salva com sucesso!";
    }

    public Optional<Task> getTaskById(UUID id){
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public String updateTask(Task task){

        if(taskRepository.existsById(task.getId())) {

            Optional<Task> updatedTask = taskRepository.findById(task.getId());

            updatedTask.get().setDescription(task.getDescription());

            updatedTask.get().setDate(task.getDate());

            taskRepository.save(updatedTask.get());

            return "Tarefa alterada com sucesso!";
        }
        return "Tarefa não encontrada!";
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
