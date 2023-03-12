package Tasksbackend.Controller;

import Tasksbackend.Model.Id;
import Tasksbackend.Service.UserService;
import Tasksbackend.Model.User;
import Tasksbackend.Model.UserBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/user")
    public ResponseEntity<Object> indexUser(){
        return ResponseEntity.status(HttpStatus.OK).body("Index user!");
    }

    @GetMapping("user/getAllUsers")
    public ResponseEntity<Object> getAllUser(){

        List<User> users = userService.getAllUsers();

        if(!users.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar todos clientes!");
    }

    @GetMapping("user/getUserById/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable UUID id){

        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuário!");
    }

    @PostMapping("/user/saveUser")
    public ResponseEntity<Object> saveUser(@RequestBody UserBase newUser){

        User user = new User(newUser.getName(), newUser.getCpf(), newUser.getEmail(), newUser.getUserName(), newUser.getPassword());

        String response = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/user/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody User user){

        String response = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(path = "/user/deleteUser")
    public  ResponseEntity<Object> deleteUser(@RequestBody Id id){

        String response = userService.deleteUser(id.getId());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
