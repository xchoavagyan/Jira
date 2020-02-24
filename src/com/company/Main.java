package com.company;

import com.company.creations.DatabaseStatement;
import com.company.creations.DisplayMenu;

public class Main {

    public static void main(String[] args) {
        DatabaseStatement.createDatabaseAndTables();
        while (true) {
            try {
                DisplayMenu.runMenu();
            } catch (RuntimeException ex) {
                System.out.println("please enter valid function");
            } catch (Exception ex) {
                System.out.println("please enter valid function");
            }
        }
    }
}
