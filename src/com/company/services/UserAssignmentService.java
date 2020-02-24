package com.company.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.company.models.DatabaseConstants.*;

public class UserAssignmentService {
    private static UserAssignmentService instance = null;

    private UserAssignmentService() {
    }

    public static UserAssignmentService getInstance() {
        if (instance == null)
            instance = new UserAssignmentService();
        return instance;
    }
    public void assignTaskToUser(String userName,String taskName){
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "UPDATE tasks SET user_id = (SELECT users.id FROM users WHERE users.name=?), state = 'IN_PROGRESS' WHERE id=(SELECT tasks.id FROM tasks WHERE tasks.name=?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,taskName);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
