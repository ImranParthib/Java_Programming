package com.example.employeemanagementsystem;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class LoginView extends VBox {
    private String authenticatedUserRole;

    public LoginView(Stage primaryStage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            if (authenticate(usernameField.getText(), passwordField.getText())) {
                TabPane tabPane = new TabPane();

                Tab dashboardTab = new Tab("Dashboard", new DashboardView());
                Tab employeeManagementTab = new Tab("Employee Management", new EmployeeManagementView());
                Tab settingsTab = new Tab("Settings");

                tabPane.getTabs().addAll(dashboardTab, employeeManagementTab, settingsTab);

                // Restrict access based on user role
                if (!authenticatedUserRole.equals("Admin")) {
                    employeeManagementTab.setDisable(true);
                }

                Scene scene = new Scene(tabPane, 800, 600);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Employee Management System");
            } else {
                // Show error message
                Label errorLabel = new Label("Invalid username or password");
                getChildren().add(errorLabel);
            }
        });

        getChildren().addAll(usernameField, passwordField, loginButton);
    }

    private boolean authenticate(String username, String password) {
        // Example hardcoded users
        List<User> users = Arrays.asList(
                new User("admin", "password", "Admin"),
                new User("manager", "password", "Manager"),
                new User("employee", "password", "Employee")
        );

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Store the authenticated user role
                authenticatedUserRole = user.getRole();
                return true;
            }
        }
        return false;
    }
}