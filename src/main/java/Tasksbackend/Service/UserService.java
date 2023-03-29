package Tasksbackend.Service;

import Tasksbackend.Repository.UserRepository;
import Tasksbackend.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public  Optional<User> getUserById(UUID id){

        return userRepository.findById(id);
    }
    public String saveUser(User user){

        userRepository.save(user);

        return "Usuário salvo com sucesso!";
    }

    public String updateUser(User user){

            Optional<User> updatedUser = userRepository.findById(user.getId());

            if(updatedUser.isPresent()) {

                updatedUser.get().setUserName(user.getUserName());

                updatedUser.get().setCpf(user.getCpf());

                updatedUser.get().setName(user.getName());

                updatedUser.get().setEmail(user.getEmail());

                updatedUser.get().setPassword(user.getPassword());

                userRepository.save(updatedUser.get());

                return "Usuário alterado com sucesso!";
            }
        return "Usuário não encontrado!";
    }

    public String deleteUser(UUID id) {

        if (userRepository.existsById(id)) {

            userRepository.deleteById(id);

            return "Usuário removido com sucesso!";
        }
        return "Usuário não encontrado";
    }
}
