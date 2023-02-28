package Tasksbackend.demo.Model.Task;


public class ModelTask {

    public  ModelTask(String id){
        this.id = id;
    }
    private String description;
    private String id;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
