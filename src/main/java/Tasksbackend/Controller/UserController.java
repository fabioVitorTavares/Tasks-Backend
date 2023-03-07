package Tasksbackend.Controller;

import Tasksbackend.Service.TaskService;
import Tasksbackend.Service.UserService;
import Tasksbackend.UserDTO.User;
import Tasksbackend.UserDTO.UserBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/user/addNewUser")
    public ResponseEntity<Object> addNewUser(@RequestBody UserBase newUser){

        User user = new User(newUser.getName(), newUser.getCpf(), newUser.getEmail(), newUser.getUserName(), newUser.getPassword());

        Optional<User> userAdded = userService.saveUser(user);

        if(userAdded.isPresent()){

            return ResponseEntity.status(HttpStatus.CREATED).body(userAdded);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar novo usuário!");
    }
}
