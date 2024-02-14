package dao;
import java.util.ArrayList;
import java.util.List;
import dto.Task;
import dto.TaskStatus;

public class TaskRepository {

    public static List<Task> taskDB = new ArrayList<>();

    public boolean addTask(Task task) {
        return taskDB.add(task);
    }

    public List<Task> getTasks() {
        return taskDB;
    }

    public List<Task> deleteTask(int taskId) {
        taskDB.removeIf(obj -> obj.getTaskId() == taskId);
        return taskDB;
    }

    public List<Task> updateTask(Task task,int taskId) {
        for(int i=0;i<taskDB.size();i++){
            if(taskDB.get(i).getTaskId()==taskId){
                Task t = taskDB.get(i);
                t.setTaskStatus(TaskStatus.DONE);
                taskDB.set(i,t);
            }
        }
        return taskDB;
    }

}
