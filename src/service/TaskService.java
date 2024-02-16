package service;

import java.util.List;

import dao.TaskRepository;
import dto.Task;

public class TaskService implements ITaskService {
    
    TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    @Override
    public boolean addTask(Task task) {
        return taskRepository.addTask(task);
        // throw new UnsupportedOperationException("Unimplemented method 'addTask'");
    }

    @Override
    public List<Task> updateTask(String fieldName,String value ,int taskId) {
        // TODO Auto-generated method stub
         return taskRepository.updateTask(fieldName,value,taskId);
    }

    @Override
    public List<Task> deleteTask(int taskId) {
        return taskRepository.deleteTask(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
        // throw new UnsupportedOperationException("Unimplemented method 'showTasks'");
    }

    @Override
    public Task getTasksById(int id) {
        return taskRepository.getTaskById(id);
    }

}
