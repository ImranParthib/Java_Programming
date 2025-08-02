import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void listDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department department : departments) {
            System.out.println("- " + department.getName());
        }
    }
}