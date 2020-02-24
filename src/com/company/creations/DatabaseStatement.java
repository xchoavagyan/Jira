package com.company.creations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.company.models.DatabaseConstants.*;

public class DatabaseStatement {
    public static void createDatabaseAndTables(){
        try (Connection conn = DriverManager.getConnection(DB_URL_D, USER, PASSWORD)) {
            String query = "CREATE DATABASE jira;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("Database Created");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String createUsersTable = "CREATE TABLE users "+
                    "(   id       int not null auto_increment,"+
                    "    name     varchar(255),"+
                    "    surname varchar(255),"+
                    "    primary key (id));";
            PreparedStatement preparedStatement = conn.prepareStatement(createUsersTable);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("Table Users Created");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String createTasksTable = "CREATE TABLE Tasks" +
                    "(    id      int not null auto_increment," +
                    "    name    varchar(255)," +
                    "    state   enum ('TO_DO','IN_PROGRESS','IN_PREVIEW','DONE')," +
                    "    user_id int,\n" +
                    "    foreign key (user_id) references users (id)," +
                    "    primary key (id));";
            PreparedStatement preparedStatement = conn.prepareStatement(createTasksTable);
            preparedStatement.executeUpdate();
            if (conn != null) {
                System.out.println("Table Tasks Created");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }
}
