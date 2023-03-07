package Tasksbackend.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class User {

    public User(String name, String cpf, String email, String userName, String password){
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    @Id
    @Column
    private UUID id;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private String email;
    @Column
    private String userName;
    @Column
    private String password;
}
