package com.company.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.company.models.DatabaseConstants.*;

public class UserUnassignmentService {
    private static UserUnassignmentService instance = null;

    private UserUnassignmentService() {
    }

    public static UserUnassignmentService getInstance() {
        if (instance == null)
            instance = new UserUnassignmentService();
        return instance;
    }
    public void unassignTaskToUser(String taskName){
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "UPDATE tasks SET user_id = NULL , state = 'TO_DO' WHERE id=(SELECT tasks.id FROM tasks WHERE tasks.name=?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,taskName);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("User is unassigned");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
}
