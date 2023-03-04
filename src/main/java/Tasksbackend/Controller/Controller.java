package Tasksbackend.Controller;

import Tasksbackend.Service.TaskService;
import Tasksbackend.TaskDTO.Task;
import Tasksbackend.TaskDTO.TaskBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class Controller {

    final TaskService taskService;

    public Controller(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("/")
    public String index(){
        return "Index";
    }

    @GetMapping("task/getTaskById/{id}")
    public ResponseEntity<Object> getTaskBiId(@PathVariable UUID id){

        Optional<Task> localizedTask = taskService.getTaskById(id);

        if(localizedTask.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(localizedTask);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tarefa não encontrada!");
    }

    @PostMapping("/task/addNewTask")
    public ResponseEntity<Object> addNewtask(@RequestBody TaskBase newTask){

       Optional<Task> taskAdded = Optional.ofNullable(taskService.addNewTask(new Task(newTask.getDescription(), newTask.getDateCreated(), newTask.getDate())));

       if(taskAdded.isPresent()){

           return ResponseEntity.status(HttpStatus.CREATED).body(taskAdded);

       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar nova tarefa!");
    }
}
