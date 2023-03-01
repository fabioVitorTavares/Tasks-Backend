package Tasksbackend.demo.Model.Task;


import java.util.Date;
import java.util.UUID;

public class ModelTask {

    public  ModelTask(String description, Date dateCreated, Date date){
        this.description = description;
        this.dateCreated = dateCreated;
        this.date = date;
        this.id = UUID.randomUUID();
    }
    private String description;
    private UUID id;

    private Date date;

    private Date dateCreated;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
