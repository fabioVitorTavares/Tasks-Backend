package Tasksbackend.Model;

import Tasksbackend.Repository.UserRepository;
import Tasksbackend.Service.UserService;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    public Task(String description, Date dateCreated, Date date, User user){
        this.description = description;
        this.dateCreated = dateCreated;
        this.date = date;
        this.user = user;
        this.id = UUID.randomUUID();
    }
    @Column
    private String description;

    @Column
    private Date date;

    @Column
    private Date dateCreated;

    @Id
    private UUID id;

    @ManyToOne
    private User user;
}
