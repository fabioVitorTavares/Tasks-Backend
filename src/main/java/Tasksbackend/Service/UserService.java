package Tasksbackend.Service;

import Tasksbackend.Repository.UserRepository;
import Tasksbackend.UserDTO.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){this.userRepository = userRepository;;}

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }
    public Optional<User> saveUser(User user){

        User userAdded  = userRepository.save(user);

        return Optional.of(userAdded);
    }

}
