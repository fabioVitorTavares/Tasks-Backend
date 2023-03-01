package Tasksbackend.demo.Controller;

import Tasksbackend.demo.Model.Task.ModelTask;
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
    public String indexTexto(@PathVariable String value) {
        System.out.println(value);
        return "Value = " + value;
    }

    @PostMapping("/tasks")
    public ResponseEntity<ModelTask> newTask(@RequestBody Mo){
        ModelTask task = new ModelTask(id);
        task.setDescription(description);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
