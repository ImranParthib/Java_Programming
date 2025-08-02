public class Main {
    public static void main(String[] args) {
        System.out.println("Starting University Management System...");

        University university = new University("Example University");
        System.out.println("University created: " + university.getName());

        Department csDepartment = new Department("Computer Science", 50000);
        university.addDepartment(csDepartment);
        System.out.println("Department added: " + csDepartment.getName());

        Course javaCourse = new Course("CS101", "Introduction to Java", "Mon-Wed-Fri 10:00-11:00");
        csDepartment.addCourse(javaCourse);
        System.out.println("Course added: " + javaCourse.getTitle());

        Student student1 = new Student("S001", "John Doe");
        javaCourse.addStudent(student1);
        System.out.println("Student enrolled: " + student1.getName());

        Professor professor1 = new Professor("P001", "Dr. Smith");
        csDepartment.addProfessor(professor1);
        System.out.println("Professor added: " + professor1.getName());

        // List all departments
        university.listDepartments();

        // List all courses in the Computer Science department
        csDepartment.listCourses();

        // List all students in the Introduction to Java course
        javaCourse.listStudents();

        // List all professors in the Computer Science department
        csDepartment.listProfessors();

        System.out.println("University Management System setup complete.");
    }
}