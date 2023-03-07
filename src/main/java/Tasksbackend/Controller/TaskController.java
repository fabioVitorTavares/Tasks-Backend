package Tasksbackend.Controller;

import Tasksbackend.Service.TaskService;
import Tasksbackend.TaskDTO.IdTask;
import Tasksbackend.TaskDTO.Task;
import Tasksbackend.TaskDTO.TaskBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TaskController {

    final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("/")
    public String index(){
        return "Index";
    }


    @GetMapping("task/getAllTasks")
    public ResponseEntity<Object> getAllTasks() {
        Optional<List<Task>> listOfTasks = Optional.of(taskService.getAllTasks());

        if(listOfTasks.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(listOfTasks.get());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar todas tarefas");
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

       Optional<Task> taskAdded = Optional.ofNullable(taskService.addNewTask(Optional.of(new Task(newTask.getDescription(), newTask.getDateCreated(), newTask.getDate()))));

       if(taskAdded.isPresent()){

           return ResponseEntity.status(HttpStatus.CREATED).body(taskAdded);

       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar nova tarefa!");
    }

    @PutMapping("/task/updateTask")
    public ResponseEntity<Object> updateTask(@RequestBody Task updateTask){

        Optional<Task> updatedTask = Optional.of(taskService.saveUpdateTask(updateTask));

        if(updatedTask.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(taskService.saveUpdateTask(updateTask));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar tarefa!");
    }

    @DeleteMapping("/task/deleteTask")
    public ResponseEntity<String> deleteById(@RequestBody IdTask id){

        String response = taskService.deleteTask(id.getId());

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
