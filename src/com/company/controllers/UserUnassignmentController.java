package com.company.controllers;

import com.company.services.UserUnassignmentService;

import java.util.Scanner;

public class UserUnassignmentController {
    private static UserUnassignmentController instance = null;
    private  static final UserUnassignmentService userUnssignmentService = UserUnassignmentService.getInstance();
    Scanner scanner = new Scanner(System.in);
    private UserUnassignmentController() {
    }

    public static UserUnassignmentController getInstance() {
        if (instance == null)
            instance = new UserUnassignmentController();
        return instance;
    }
    public void setUnassignTaskToUser(){
        System.out.println("Please insert TaskName to Unassign");
        String taskName = scanner.nextLine().toString();
        userUnssignmentService.unassignTaskToUser(taskName);
    }

}
