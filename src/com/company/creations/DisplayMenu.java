package com.company.creations;

import com.company.controllers.TaskController;
import com.company.controllers.UserAssignmentController;
import com.company.controllers.UserController;
import com.company.controllers.UserUnassignmentController;

import java.util.Scanner;

public class DisplayMenu {

    public static void runMenu() {

        Scanner scanner = new Scanner(System.in);
        UserController userController = UserController.getInstance();
        TaskController taskController = TaskController.getInstance();
        UserAssignmentController userAssignmentController = UserAssignmentController.getInstance();
        UserUnassignmentController userUnassignmentController = UserUnassignmentController.getInstance();
        boolean whileLoop = true;
        while (whileLoop) {
            System.out.println("----------MENU----------");
            System.out.println("1. for User CRUD");
            System.out.println("2. for Task CRUD");
            System.out.println("3. to Assign Task to User");
            System.out.println("4. to unassign User");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    System.out.println("----------MENU--USER--CRUD------");
                    System.out.println("1. Create User");
                    System.out.println("2. Find all Users");
                    System.out.println("3. Find User by id");
                    System.out.println("4. Update user by id");
                    System.out.println("5. Delete user by id");
                    System.out.println("6. For back");
                    System.out.println("7. For exit");
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            userController.initializeUser();
                            break;
                        case 2:
                            System.out.println(userController.findAllUsers());
                            break;
                        case 3:
                            System.out.println(userController.findUserByID());
                            break;
                        case 4:
                            userController.updateUser();
                            break;
                        case 5:
                            userController.deleteUser();
                            break;
                        case 6:
                            break;
                        case 7:
                            whileLoop = false;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("----------MENU--TASK--CRUD------");
                    System.out.println("1. Create Task");
                    System.out.println("2. Find all Tasks");
                    System.out.println("3. Find Task by id");
                    System.out.println("4. Update Task by id");
                    System.out.println("5. Delete Task by id");
                    System.out.println("6. For back");
                    System.out.println("7. For exit");

                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            taskController.initializeTask();
                            break;
                        case 2:
                            System.out.println(taskController.findAllTasks());
                            break;
                        case 3:
                            System.out.println(taskController.findTaskByID());
                            break;
                        case 4:
                            taskController.updateTask();
                            break;
                        case 5:
                            taskController.deleteTask();
                            break;
                        case 6:
                            break;
                        case 7:
                            whileLoop = false;
                            break;
                    }
                    break;
                case 3:
                    userAssignmentController.setAssignTaskToUser();
                    break;
                case 4:
                    userUnassignmentController.setUnassignTaskToUser();
                    break;


            }

        }
    }
}
