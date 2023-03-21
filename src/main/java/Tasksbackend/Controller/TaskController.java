package Tasksbackend.Controller;

import Tasksbackend.Model.User;
import Tasksbackend.Service.TaskService;
import Tasksbackend.Model.Id;
import Tasksbackend.Model.Task;
import Tasksbackend.Model.TaskBase;
import Tasksbackend.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TaskController {

    final TaskService taskService;
    final UserService userService;

    public TaskController(TaskService taskService, UserService userService){

        this.taskService = taskService;
        this.userService = userService;
    }
    @GetMapping("/")
    public String index(){
        return "Index";
    }

    @CrossOrigin("*")
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

    @PostMapping("/task/saveTask")
    public ResponseEntity<Object> saveTask(@RequestBody TaskBase newTask){
       Optional<User> user = userService.getUserById(newTask.getIdUser());

       if(user.isPresent()) {

           User userAdded = user.get();

           Task taskAdded = new Task(newTask.getDescription(), newTask.getDateCreated(), newTask.getDate(), userAdded);

           String response = taskService.saveTask(taskAdded);

           return ResponseEntity.status(HttpStatus.CREATED).body(response);
       }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Usuário não encontrado!");
    }

    @PutMapping("/task/updateTask")
    public ResponseEntity<Object> updateTask(@RequestBody Task updateTask){

        String response = taskService.updateTask(updateTask);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/task/deleteTask")
    public ResponseEntity<String> deleteById(@RequestBody Id id){

        String response = taskService.deleteTask(id.getId());

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
