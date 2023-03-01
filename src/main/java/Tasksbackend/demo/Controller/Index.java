package Tasksbackend.demo.Controller;
import Tasksbackend.demo.Model.Task.ModelTask;
import Tasksbackend.demo.TaskDTO.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Index {

    ModelTask task;

    @GetMapping("/")
    public String indexMessage() {
        return "Hello World!";
    }

    @GetMapping("/tasks")
    public ResponseEntity<ModelTask> getTask() {
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PostMapping("/tasks")
    public ResponseEntity newTask(@RequestBody TaskDTO taskDTO){

        task = new ModelTask(taskDTO.getDescription(), taskDTO.getDate(), taskDTO.getDateCreated());

        return ResponseEntity.status(HttpStatus.OK).body("Task adicionada com sucesso!");
    }
}
