package Tasksbackend.Model;

import lombok.Getter;

import java.util.Date;

@Getter
public class TaskBase {

    private String description;

    private Date date;

    private Date dateCreated;

}
