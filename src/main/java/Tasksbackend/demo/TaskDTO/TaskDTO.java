package Tasksbackend.demo.TaskDTO;

import java.util.Date;
import java.util.UUID;

public class TaskDTO {
    private String description;

    private Date date;

    private Date dateCreated;

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
