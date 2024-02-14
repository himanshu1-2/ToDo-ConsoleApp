package controller;

import java.util.List;

import dto.Task;
import dto.TaskStatus;
import service.ITaskService;
import service.TaskService;

public class ToDoController {

  private final ITaskService taskService = new TaskService();

  public void runToDoApp() {
    try{
      while (true) {
        showMenu();
        String userAction = getUserInput("Enter the Action Number");
        performAction(Integer.parseInt(userAction));
      }
    }
    catch (NumberFormatException e){
      System.out.println("Invalid input please provide number");
    }

  }

  private void showMenu() {
    System.out.println("Welcome to the ToDo App!");
    System.out.println("Action Menu: ");
    System.out.println("1. Add a new task");
    System.out.println("2. Update an existing task");
    System.out.println("3. Delete an existing task");
    System.out.println("4. List all Tasks");
    System.out.println("5. Exit");
  }

  private String getUserInput(String inputMessage) {
    System.out.print(inputMessage + " : ");
    return System.console().readLine();
  }

  private void performAction(int action) {
    switch (action) {
      case 1:
        addTask();
        break;
      case 2:
        updateTask();
        break;
      case 3:
        deleteTask();
        break;
      case 4:
        getTasks();
        break;
      case 5:
        System.exit(200);
      default:
        System.out.println("Invalid Action");
    }
  }

  private void addTask() {
    String taskName = getUserInput("Enter the Task Name");
    String taskDeadline = getUserInput(
        "Enter the Task Deadline in format as 01-Jan-2024 [Optional, Press Enter to skip] ");

    Task task = new Task(Task.getTaskAutoId(), taskName, TaskStatus.PENDING, taskDeadline);
    taskService.addTask(task);

  }

  private void updateTask() {
    String taskId = getUserInput("Enter the Task id to update");
    taskService.updateTask(null,Integer.parseInt(taskId));

  }

  private void deleteTask() {
    String taskId = getUserInput("Enter the Task id");
    List<Task>task= taskService.deleteTask(Integer.parseInt(taskId));

  }

  private void getTasks() {
    List<Task> tasks = taskService.getTasks();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("ID" + " | " + "TASK NAME" + " | " + "TASK STATUS" + " | " + "DEADLINE");
    System.out.println("-------------------------------------------------------------------------------");
    tasks.forEach(task -> System.out.println(task.getTaskId() + " | " + task.getTaskName() + " | " + task.getTaskStatus() + " | "
        + task.getTaskDeadline()));
    System.out.println("-------------------------------------------------------------------------------");
  }

}
