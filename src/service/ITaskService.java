package service;

import java.util.List;

import dto.Task;

public interface ITaskService {

    public boolean addTask(Task task);

    public List<Task> updateTask(String fieldName,String value,int taskId);

    public List<Task> deleteTask(int taskId);

    public List<Task> getTasks();

    public Task getTasksById(int id);

}
