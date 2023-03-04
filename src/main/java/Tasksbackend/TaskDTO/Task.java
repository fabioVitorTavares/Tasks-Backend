package Tasksbackend.TaskDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "tasks")
@Getter
public class Task {

    public Task(String description, Date dateCreated, Date date){
        this.description = description;
        this.dateCreated = dateCreated;
        this.date = date;
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
}
