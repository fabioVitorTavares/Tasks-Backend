package Tasksbackend.demo.Controller;

import Tasksbackend.demo.Model.Task.ModelTask;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @GetMapping("/")
    public String indexMessage() {
        return "Hello World!";
    }

    @GetMapping("/{value}")
    public String indexTexto(@PathVariable String value) {
        System.out.println(value);
        return "Value = " + value;
    }

    @GetMapping("/{id}/{description}")
    public ResponseEntity<ModelTask> newTask(@PathVariable String id,@PathVariable String description){
        ModelTask task = new ModelTask(id);
        task.setDescription(description);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
