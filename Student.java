package StudentGradeSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    
    // Fields
    private String name;
    private List<Double> grades;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    // Add a grade
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Calculate average
    public double getAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    // Get highest grade
    public double getHighest() {
        if (grades.isEmpty()) return 0;
        double highest = grades.get(0);
        for (double g : grades) {
            if (g > highest) highest = g;
        }
        return highest;
    }

    // Get lowest grade
    public double getLowest() {
        if (grades.isEmpty()) return 0;
        double lowest = grades.get(0);
        for (double g : grades) {
            if (g < lowest) lowest = g;
        }
        return lowest;
    }

    // Getters
    public String getName() { return name; }
    public List<Double> getGrades() { return grades; }

    // Display student info
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Name    : " + name);
        System.out.println("Grades  : " + grades);
        System.out.println("Average : " + getAverage());
        System.out.println("Highest : " + getHighest());
        System.out.println("Lowest  : " + getLowest());
        System.out.println("-----------------------------");
    }
}