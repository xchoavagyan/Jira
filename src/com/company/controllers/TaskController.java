package com.company.controllers;

import com.company.models.State;
import com.company.models.Task;
import com.company.services.TaskService;

import java.util.List;
import java.util.Scanner;

public class TaskController {
    private static TaskController instance = null;
    private static TaskService taskService = TaskService.getInstance();
    Scanner scanner = new Scanner(System.in);

    private TaskController() {
    }

    public static TaskController getInstance() {
        if (instance == null)
            instance = new TaskController();
        return instance;
    }
    public void initializeTask(){
        Task task = new Task();
        System.out.println("Please insert Task : name,");
        System.out.println("Name : ");
        task.setName(scanner.nextLine());
        task.setState(State.TO_DO);
        taskService.create(task);
    }
    public Task findTaskByID(){
        System.out.println("Please insert Task ID :");
        return taskService.findByID(scanner.nextInt());
    }

    public List<Task> findAllTasks(){
        List<Task> allTasks = taskService.findAll();
        return allTasks;
    }
    public void deleteTask(){
        System.out.println("Please insert Task ID to delete");
        taskService.delete(scanner.nextInt());
    }
    public void updateTask(){
        Task task = new Task();
        System.out.println("Please insert Task ID to Update");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please insert Task name : ");
        task.setName(scanner.nextLine());
        task.setState(State.TO_DO);
        taskService.update(id,task);
    }

}
