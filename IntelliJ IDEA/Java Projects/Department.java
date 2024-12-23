import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Course> courses;
    private List<Professor> professors;
    private double budget;

    public Department(String name, double budget) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.budget = budget;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void listCourses() {
        System.out.println("Courses in " + name + " Department:");
        for (Course course : courses) {
            System.out.println("- " + course.getTitle());
        }
    }

    public void listProfessors() {
        System.out.println("Professors in " + name + " Department:");
        for (Professor professor : professors) {
            System.out.println("- " + professor.getName());
        }
    }
}