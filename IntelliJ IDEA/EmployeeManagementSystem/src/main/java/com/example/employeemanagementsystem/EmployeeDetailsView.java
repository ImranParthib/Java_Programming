package com.example.employeemanagementsystem;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeeDetailsView extends VBox {

    public EmployeeDetailsView(Employee employee) {
        getChildren().addAll(
                new Label("Name: " + employee.getName()),
                new Label("ID: " + employee.getId()),
                new Label("Department: " + employee.getDepartment()),
                new Label("Salary: " + employee.getSalary())
        );
    }

    public static void showEmployeeDetails(Employee employee) {
        Stage detailsStage = new Stage();
        detailsStage.setScene(new Scene(new EmployeeDetailsView(employee), 300, 200));
        detailsStage.setTitle("Employee Details");
        detailsStage.show();
    }
}