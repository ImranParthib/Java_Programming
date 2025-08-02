import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversityManagementSystemGUI {
    private University university;
    private User currentUser;

    public UniversityManagementSystemGUI() {
        // Initialize the university object
        university = new University("Daffodil International University");

        JFrame frame = new JFrame("University Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        // Show registration dialog
        RegisterDialog registerDialog = new RegisterDialog(frame);
        registerDialog.setVisible(true);
        if (!registerDialog.isSucceeded()) {
            System.exit(0);
        }

        // Show login dialog
        LoginDialog loginDialog = new LoginDialog(frame);
        loginDialog.setVisible(true);
        if (loginDialog.isSucceeded()) {
            currentUser = new User("admin", "password", "admin"); // Replace with actual user data
        } else {
            System.exit(0);
        }



        // Custom panel with background image
        BackgroundPanel panel = new BackgroundPanel(new ImageIcon("university_banner.jpg").getImage());
        panel.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Load the image
        ImageIcon universityIcon = new ImageIcon("university.png");

        // Create a JLabel with the image
        JLabel universityLabel = new JLabel(universityIcon);
        universityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // make the image size smaller
        Image image = universityIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(600, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        universityIcon = new ImageIcon(newimg);  // transform it back
        universityLabel.setIcon(universityIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(universityLabel, gbc);

        // Search bar and button
        JTextField searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 18));
        searchField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(120, 130, 180), 2, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        contentPanel.add(searchField, gbc);

        JButton searchButton = createButton("Search", e -> search(searchField.getText()), new Color(120, 130, 180));
        searchButton.setToolTipText("Search for departments, courses, students, or professors");
        searchButton.setFont(new Font("Arial", Font.BOLD, 18));
        searchButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(120, 130, 180), 1, true),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.setFocusPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(0, 119, 230));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 119, 230), 2, true),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPanel.add(searchButton, gbc);





        JButton listDepartmentsButton = createButton("List Departments", e -> listDepartments(), new Color(60, 179, 113));
        listDepartmentsButton.setToolTipText("List all departments in the university");
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(listDepartmentsButton, gbc);

        JButton addDepartmentButton = createButton("Add Department", e -> addDepartment(), new Color(60, 179, 113));
        addDepartmentButton.setToolTipText("Add a new department to the university");
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPanel.add(addDepartmentButton, gbc);

        JButton viewDepartmentButton = createButton("View Department", e -> viewDepartment(), new Color(70, 130, 180));
        viewDepartmentButton.setToolTipText("View details of a specific department");
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(viewDepartmentButton, gbc);

        JButton editDepartmentButton = createButton("Edit Department", e -> editDepartment(), new Color(255, 165, 0));
        editDepartmentButton.setToolTipText("Edit details of a specific department");
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPanel.add(editDepartmentButton, gbc);

        JButton deleteDepartmentButton = createButton("Delete Department", e -> deleteDepartment(), Color.RED);
        deleteDepartmentButton.setToolTipText("Delete a specific department");
        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPanel.add(deleteDepartmentButton, gbc);

        JButton listCoursesButton = createButton("List Courses", e -> listCourses(), new Color(60, 179, 113));
        listCoursesButton.setToolTipText("List all courses in the university");
        gbc.gridx = 0;
        gbc.gridy = 6;
        contentPanel.add(listCoursesButton, gbc);

        JButton addCourseButton = createButton("Add Course", e -> addCourse(), new Color(60, 179, 113));
        addCourseButton.setToolTipText("Add a new course to a department");
        gbc.gridx = 1;
        gbc.gridy = 6;
        contentPanel.add(addCourseButton, gbc);

        JButton viewCourseButton = createButton("View Course", e -> viewCourse(), new Color(70, 130, 180));
        viewCourseButton.setToolTipText("View details of a specific course");
        gbc.gridx = 0;
        gbc.gridy = 7;
        contentPanel.add(viewCourseButton, gbc);

        JButton editCourseButton = createButton("Edit Course", e -> editCourse(), new Color(255, 165, 0));
        editCourseButton.setToolTipText("Edit details of a specific course");
        gbc.gridx = 1;
        gbc.gridy = 7;
        contentPanel.add(editCourseButton, gbc);

        JButton deleteCourseButton = createButton("Delete Course", e -> deleteCourse(), Color.RED);
        deleteCourseButton.setToolTipText("Delete a specific course");
        gbc.gridx = 0;
        gbc.gridy = 8;
        contentPanel.add(deleteCourseButton, gbc);

        JButton listStudentsButton = createButton("List Students", e -> listStudents(), new Color(60, 179, 113));
        listStudentsButton.setToolTipText("List all students in the university");
        gbc.gridx = 0;
        gbc.gridy = 9;
        contentPanel.add(listStudentsButton, gbc);

        JButton addStudentButton = createButton("Add Student", e -> addStudent(), new Color(60, 179, 113));
        addStudentButton.setToolTipText("Add a new student to a course");
        gbc.gridx = 1;
        gbc.gridy = 9;
        contentPanel.add(addStudentButton, gbc);

        JButton listProfessorsButton = createButton("List Professors", e -> listProfessors(), new Color(60, 179, 113));
        listProfessorsButton.setToolTipText("List all professors in the university");
        gbc.gridx = 0;
        gbc.gridy = 10;
        contentPanel.add(listProfessorsButton, gbc);

        JButton addProfessorButton = createButton("Add Professor", e -> addProfessor(), new Color(60, 179, 113));
        addProfessorButton.setToolTipText("Add a new professor to a department");
        gbc.gridx = 1;
        gbc.gridy = 10;
        contentPanel.add(addProfessorButton, gbc);

        panel.add(contentPanel, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private JButton createButton(String text, ActionListener actionListener, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.addActionListener(actionListener);
        if (backgroundColor != null) {
            button.setBackground(backgroundColor);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setForeground(Color.WHITE);
        }
        return button;
    }

    private void search(String query) {
        StringBuilder result = new StringBuilder("Search results for \"" + query + "\":\n");

        for (Department department : university.getDepartments()) {
            if (department.getName().equalsIgnoreCase(query)) {
                result.append("Department: ").append(department.getName()).append("\n");
            }
            for (Course course : department.getCourses()) {
                if (course.getTitle().equalsIgnoreCase(query)) {
                    result.append("Course: ").append(course.getTitle()).append(" (").append(department.getName()).append(")\n");
                }
                for (Student student : course.getStudents()) {
                    if (student.getName().equalsIgnoreCase(query)) {
                        result.append("Student: ").append(student.getName()).append(" (").append(course.getTitle()).append(")\n");
                    }
                }
            }
            for (Professor professor : department.getProfessors()) {
                if (professor.getName().equalsIgnoreCase(query)) {
                    result.append("Professor: ").append(professor.getName()).append(" (").append(department.getName()).append(")\n");
                }
            }
        }

        DetailDialog dialog = new DetailDialog(null, "Search Results", result.toString());
        dialog.setVisible(true);
    }

    private void listDepartments() {
        String[] columnNames = {"Department Name", "Budget"};
        Object[][] data = new Object[university.getDepartments().size()][2];

        int i = 0;
        for (Department department : university.getDepartments()) {
            data[i][0] = department.getName();
            data[i][1] = department.getBudget();
            i++;
        }

        ListDialog dialog = new ListDialog(null, "Departments in " + university.getName(), columnNames, data);
        dialog.setVisible(true);
    }

    private void addDepartment() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        double budget = Double.parseDouble(JOptionPane.showInputDialog("Enter Department Budget:"));
        Department department = new Department(departmentName, budget);
        university.addDepartment(department);
        JOptionPane.showMessageDialog(null, "Department added: " + department.getName());
    }

    private void viewDepartment() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name to View:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            StringBuilder details = new StringBuilder("Details of Department: " + department.getName() + "\n");
            details.append("Budget: ").append(department.getBudget()).append("\n");
            details.append("Courses:\n");
            for (Course course : department.getCourses()) {
                details.append("- ").append(course.getTitle()).append("\n");
            }
            details.append("Professors:\n");
            for (Professor professor : department.getProfessors()) {
                details.append("- ").append(professor.getName()).append("\n");
            }
            DetailDialog dialog = new DetailDialog(null, "Department Details", details.toString());
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void editDepartment() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name to Edit:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String newDepartmentName = JOptionPane.showInputDialog("Enter New Department Name:", department.getName());
            double newBudget = Double.parseDouble(JOptionPane.showInputDialog("Enter New Department Budget:", department.getBudget()));
            department.setName(newDepartmentName);
            department.setBudget(newBudget);
            JOptionPane.showMessageDialog(null, "Department updated: " + department.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void deleteDepartment() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name to Delete:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            university.getDepartments().remove(department);
            JOptionPane.showMessageDialog(null, "Department deleted: " + department.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void listCourses() {
        String[] columnNames = {"Course Code", "Course Title", "Department", "Schedule"};
        List<Object[]> dataList = new ArrayList<>();

        for (Department department : university.getDepartments()) {
            for (Course course : department.getCourses()) {
                Object[] row = {
                        course.getCode(),
                        course.getTitle(),
                        department.getName(),
                        course.getSchedule()
                };
                dataList.add(row);
            }
        }

        Object[][] data = dataList.toArray(new Object[0][]);
        ListDialog dialog = new ListDialog(null, "Courses in " + university.getName(), columnNames, data);
        dialog.setVisible(true);
    }



    private void addCourse() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String courseCode = JOptionPane.showInputDialog("Enter Course Code:");
            String courseTitle = JOptionPane.showInputDialog("Enter Course Title:");
            String courseSchedule = JOptionPane.showInputDialog("Enter Course Schedule:");
            Course course = new Course(courseCode, courseTitle, courseSchedule);
            department.addCourse(course);
            JOptionPane.showMessageDialog(null, "Course added: " + course.getTitle());
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void viewCourse() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String courseCode = JOptionPane.showInputDialog("Enter Course Code to View:");
            Course course = findCourseByCode(department, courseCode);
            if (course != null) {
                StringBuilder details = new StringBuilder("Details of Course: " + course.getTitle() + "\n");
                details.append("Code: ").append(course.getCode()).append("\n");
                details.append("Schedule: ").append(course.getSchedule()).append("\n");
                details.append("Students:\n");
                for (Student student : course.getStudents()) {
                    details.append("- ").append(student.getName()).append("\n");
                }
                DetailDialog dialog = new DetailDialog(null, "Course Details", details.toString());
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Course not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void editCourse() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String courseCode = JOptionPane.showInputDialog("Enter Course Code to Edit:");
            Course course = findCourseByCode(department, courseCode);
            if (course != null) {
                String newCourseTitle = JOptionPane.showInputDialog("Enter New Course Title:", course.getTitle());
                String newCourseSchedule = JOptionPane.showInputDialog("Enter New Course Schedule:", course.getSchedule());
                course.setTitle(newCourseTitle);
                course.setSchedule(newCourseSchedule);
                JOptionPane.showMessageDialog(null, "Course updated: " + course.getTitle());
            } else {
                JOptionPane.showMessageDialog(null, "Course not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void deleteCourse() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String courseCode = JOptionPane.showInputDialog("Enter Course Code to Delete:");
            Course course = findCourseByCode(department, courseCode);
            if (course != null) {
                department.getCourses().remove(course);
                JOptionPane.showMessageDialog(null, "Course deleted: " + course.getTitle());
            } else {
                JOptionPane.showMessageDialog(null, "Course not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void listStudents() {
        String[] columnNames = {"Student ID", "Student Name", "Course", "Department"};
        List<Object[]> dataList = new ArrayList<>();

        for (Department department : university.getDepartments()) {
            for (Course course : department.getCourses()) {
                for (Student student : course.getStudents()) {
                    Object[] row = {
                            student.getId(),
                            student.getName(),
                            course.getTitle(),
                            department.getName()
                    };
                    dataList.add(row);
                }
            }
        }

        Object[][] data = dataList.toArray(new Object[0][]);
        ListDialog dialog = new ListDialog(null, "Students in " + university.getName(), columnNames, data);
        dialog.setVisible(true);
    }

    private void addStudent() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String courseCode = JOptionPane.showInputDialog("Enter Course Code:");
            Course course = findCourseByCode(department, courseCode);
            if (course != null) {
                String studentId = JOptionPane.showInputDialog("Enter Student ID:");
                String studentName = JOptionPane.showInputDialog("Enter Student Name:");
                Student student = new Student(studentId, studentName);
                course.addStudent(student);
                JOptionPane.showMessageDialog(null, "Student added: " + student.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Course not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private void listProfessors() {
        String[] columnNames = {"Professor ID", "Professor Name", "Department"};
        List<Object[]> dataList = new ArrayList<>();

        for (Department department : university.getDepartments()) {
            for (Professor professor : department.getProfessors()) {
                Object[] row = {
                        professor.getId(),
                        professor.getName(),
                        department.getName()
                };
                dataList.add(row);
            }
        }

        Object[][] data = dataList.toArray(new Object[0][]);
        ListDialog dialog = new ListDialog(null, "Professors in " + university.getName(), columnNames, data);
        dialog.setVisible(true);
    }

    private void addProfessor() {
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        Department department = findDepartmentByName(departmentName);
        if (department != null) {
            String professorId = JOptionPane.showInputDialog("Enter Professor ID:");
            String professorName = JOptionPane.showInputDialog("Enter Professor Name:");
            Professor professor = new Professor(professorId, professorName);
            department.addProfessor(professor);
            JOptionPane.showMessageDialog(null, "Professor added: " + professor.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Department not found.");
        }
    }

    private Department findDepartmentByName(String name) {
        for (Department department : university.getDepartments()) {
            if (department.getName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        return null;
    }

    private Course findCourseByCode(Department department, String code) {
        for (Course course : department.getCourses()) {
            if (course.getCode().equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Set the look and feel to the system's look and feel for a more modern appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new UniversityManagementSystemGUI();
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}