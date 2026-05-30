package StudentGradeSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    // Save all students to file
    public static void saveToFile(List<Student> students) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Student s : students) {
                // Format: NAME,grade1,grade2,grade3
                writer.write(s.getName());
                for (double grade : s.getGrades()) {
                    writer.write("," + grade);
                }
                writer.newLine();
            }

            writer.close();
            System.out.println("✓ Data saved successfully!");

        } catch (IOException e) {
            System.out.println("✗ Error saving data: " + e.getMessage());
        }
    }

    // Load all students from file
    public static List<Student> loadFromFile() {
        List<Student> students = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);

            // If file doesn't exist yet, return empty list
            if (!file.exists()) return students;

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 1) {
                    Student student = new Student(parts[0]); // first part is name

                    // Rest are grades
                    for (int i = 1; i < parts.length; i++) {
                        student.addGrade(Double.parseDouble(parts[i]));
                    }

                    students.add(student);
                }
            }

            reader.close();
            System.out.println("✓ Data loaded successfully!");

        } catch (IOException e) {
            System.out.println("✗ Error loading data: " + e.getMessage());
        }

        return students;
    }
}