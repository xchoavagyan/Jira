package com.company.services;

import com.company.models.State;
import com.company.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.models.DatabaseConstants.*;

public class TaskService {
    private static TaskService instance = null;

    private TaskService() {
    }

    public static TaskService getInstance() {
        if (instance == null)
            instance = new TaskService();
        return instance;
    }

    public boolean create(Task task) {
        boolean flag = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "INSERT INTO tasks(name, state) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getState().toString());
            preparedStatement.executeUpdate();

            if (conn != null) {
                System.out.println("Connected to the database");
                flag = true;
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
            return flag;
        }
        return flag;
    }

    public Task findByID(int id) {
        Task task = new Task();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT * FROM tasks WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                task.setName(resultSet.getString("name"));
                task.setState(State.valueOf(resultSet.getString("state")));
            }

            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return task;
    }

    public List<Task> findAll() {
        List<Task> list = new ArrayList();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT * FROM tasks ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setName(resultSet.getString("name"));
                task.setState(State.valueOf(resultSet.getString("duration")));
                list.add(task);
            }
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return list;
    }

    public boolean delete(int id) {
        boolean flag = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "DELETE FROM tasks WHERE id =?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);
            flag = preparedStatement.execute();
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return flag;
    }

    public boolean update(int id, Task task) {
        boolean flag = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "UPDATE tasks SET name = ?, state = ? WHERE id =?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getState().toString());
            preparedStatement.setLong(3, id);
            flag = preparedStatement.execute();
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

        return flag;
    }
}
