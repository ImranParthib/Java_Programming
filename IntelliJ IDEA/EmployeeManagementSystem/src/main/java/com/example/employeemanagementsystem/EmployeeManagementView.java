package com.example.employeemanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EmployeeManagementView extends VBox {
    private TableView<Employee> tableView;
    private FilteredList<Employee> filteredList;

    public EmployeeManagementView() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        filteredList = new FilteredList<>(employeeList, p -> true);

        tableView = new TableView<>(filteredList);
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Employee, String> idColumn = new TableColumn<>("ID");
        TableColumn<Employee, String> departmentColumn = new TableColumn<>("Department");
        TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");

        tableView.getColumns().addAll(nameColumn, idColumn, departmentColumn, salaryColumn);

        nameColumn.setSortType(TableColumn.SortType.ASCENDING);
        idColumn.setSortType(TableColumn.SortType.ASCENDING);
        departmentColumn.setSortType(TableColumn.SortType.ASCENDING);
        salaryColumn.setSortType(TableColumn.SortType.ASCENDING);

        tableView.getSortOrder().addAll(nameColumn, idColumn, departmentColumn, salaryColumn);

        TextField searchField = new TextField();
        searchField.setPromptText("Search");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return employee.getName().toLowerCase().contains(lowerCaseFilter) ||
                        employee.getId().toLowerCase().contains(lowerCaseFilter) ||
                        employee.getDepartment().toLowerCase().contains(lowerCaseFilter);
            });
        });

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField idField = new TextField();
        idField.setPromptText("ID");
        TextField departmentField = new TextField();
        departmentField.setPromptText("Department");
        TextField salaryField = new TextField();
        salaryField.setPromptText("Salary");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            Employee employee = new Employee(nameField.getText(), idField.getText(), departmentField.getText(), Double.parseDouble(salaryField.getText()));
            employeeList.add(employee);
            nameField.clear();
            idField.clear();
            departmentField.clear();
            salaryField.clear();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
            employeeList.remove(selectedEmployee);
        });

        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> {
            Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
            if (selectedEmployee != null) {
                nameField.setText(selectedEmployee.getName());
                idField.setText(selectedEmployee.getId());
                departmentField.setText(selectedEmployee.getDepartment());
                salaryField.setText(String.valueOf(selectedEmployee.getSalary()));
                employeeList.remove(selectedEmployee);
            }
        });

        Button detailsButton = new Button("View Details");
        detailsButton.setOnAction(e -> {
            Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
            if (selectedEmployee != null) {
                EmployeeDetailsView.showEmployeeDetails(selectedEmployee);
            }
        });

        getChildren().addAll(searchField, tableView, nameField, idField, departmentField, salaryField, addButton, deleteButton, editButton, detailsButton);
    }
}