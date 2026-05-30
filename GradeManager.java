package StudentGradeSystem;

import java.util.ArrayList;
import java.util.List;

public class GradeManager {

    // List to store all students
    private List<Student> students;

    // Constructor
    public GradeManager() {
        this.students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(String name) {
        // Check if student already exists
        if (findStudent(name) != null) {
            System.out.println("⚠ Student '" + name + "' already exists!");
            return;
        }
        students.add(new Student(name));
        System.out.println("✓ Student '" + name + "' added successfully!");
    }

    // Add grade to existing student
    public void addGradeToStudent(String name, double grade) {
        Student student = findStudent(name);
        if (student != null) {
            student.addGrade(grade);
            System.out.println("✓ Grade " + grade + " added to " + name);
        } else {
            System.out.println("✗ Student '" + name + "' not found!");
        }
    }

    // Find a student by name
    public Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // Display all students
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("\n===== All Students =====");
        for (Student s : students) {
            s.displayInfo();
        }
    }

    // Display one student
    public void displayStudent(String name) {
        Student student = findStudent(name);
        if (student != null) {
            student.displayInfo();
        } else {
            System.out.println("✗ Student '" + name + "' not found!");
        }
    }

    // Remove a student
    public void removeStudent(String name) {
        Student student = findStudent(name);
        if (student != null) {
            students.remove(student);
            System.out.println("✓ Student '" + name + "' removed!");
        } else {
            System.out.println("✗ Student '" + name + "' not found!");
        }
    }

    // Getter for all students (needed for FileHandler)
    public List<Student> getAllStudents() {
        return students;
    }

    // Set students list (needed when loading from file)
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}