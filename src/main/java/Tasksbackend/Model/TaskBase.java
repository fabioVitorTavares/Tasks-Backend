package Tasksbackend.Model;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class TaskBase {

    private String description;

    private Date date;

    private Date dateCreated;

    private UUID idUser;
}
