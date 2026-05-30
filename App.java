package StudentGradeSystem;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        GradeManager manager = new GradeManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("================================");
        System.out.println("  Student Grade Management System");
        System.out.println("================================");

        do {
            System.out.println("\n---------- MENU ----------");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. View All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    manager.addStudent(name);
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine(); // clear buffer
                    manager.addGradeToStudent(sName, grade);
                    break;

                case 3:
                    manager.displayAll();
                    break;

                case 4:
                    System.out.print("Enter student name to search: ");
                    String searchName = sc.nextLine();
                    manager.displayStudent(searchName);
                    break;

                case 5:
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine();
                    manager.removeStudent(removeName);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

        } while (choice != 6);

        sc.close();
    }
}