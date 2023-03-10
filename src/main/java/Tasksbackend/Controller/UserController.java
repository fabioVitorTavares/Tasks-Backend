package Tasksbackend.Controller;

import Tasksbackend.Service.TaskService;
import Tasksbackend.Service.UserService;
import Tasksbackend.UserDTO.User;
import Tasksbackend.UserDTO.UserBase;
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
    public ResponseEntity<Object> getUserById(@RequestParam UUID id){

        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuário!");
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

    @PutMapping("/user/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody User user){

        Optional<User> userUpdated = userService.saveUpdateUser(user);

        if(userUpdated.isPresent()){

            return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar usuário!");
    }

}
