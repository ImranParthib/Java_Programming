import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private List<Student> students;
    private String schedule;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
        this.students = new ArrayList<>();
    }

    public Course(String code, String title, String schedule) {
        this.code = code;
        this.title = title;
        this.schedule = schedule;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void listStudents() {
        System.out.println("Students in " + title + " course:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}