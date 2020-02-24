package com.company.controllers;

import com.company.models.User;
import com.company.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private static UserController instance = null;
    private static UserService userService = UserService.getInstance();
    Scanner scanner = new Scanner(System.in);

    private UserController() {
    }

    public static UserController getInstance() {
        if (instance == null)
            instance = new UserController();
        return instance;
    }
    public void initializeUser(){
        User user = new User();
        System.out.println("Please insert User : name, surname");
        System.out.println("Name : ");
        user.setName(scanner.nextLine());
        System.out.println("Surname : ");
        user.setSurname(scanner.nextLine());
        userService.create(user);
    }
    public User findUserByID(){
        System.out.println("Please insert user ID :");
        return userService.findByID(scanner.nextInt());
    }

    public List<User> findAllUsers(){
        List<User> allUsers = userService.findAll();
        return allUsers;
    }
    public void deleteUser(){
        System.out.println("Please insert User ID to delete");
        userService.delete(scanner.nextInt());
    }
    public void updateUser(){
        User user = new User();
        System.out.println("Please insert User ID to Update");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please insert User name : ");
        user.setName(scanner.nextLine());
        System.out.println("Please insert User surname : ");
        user.setSurname(scanner.nextLine());
        userService.update(id,user);
    }

}
