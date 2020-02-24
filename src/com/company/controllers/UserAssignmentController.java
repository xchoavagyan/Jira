package com.company.controllers;

import com.company.services.UserAssignmentService;

import java.util.Scanner;

public class UserAssignmentController {
    private static UserAssignmentController instance = null;
    private  static final UserAssignmentService userAssignmentService = UserAssignmentService.getInstance();
    Scanner scanner = new Scanner(System.in);
    private UserAssignmentController() {
    }

    public static UserAssignmentController getInstance() {
        if (instance == null)
            instance = new UserAssignmentController();
        return instance;
    }

    public void setAssignTaskToUser(){
        System.out.println("Please insert UserName to add to Task");
        String userName = scanner.nextLine();
        System.out.println("Please insert TaskName");
        String taskName = scanner.nextLine();
        userAssignmentService.assignTaskToUser(userName,taskName);
    }
}
