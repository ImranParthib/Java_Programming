package com.example.employeemanagementsystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeManagementApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView(primaryStage);
        Scene scene = new Scene(loginView, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Management System - Login");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}