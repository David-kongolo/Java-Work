
import java.util.Scanner;

public class PrimeHighSchoolSystem {

    static Scanner input = new Scanner(System.in);

    static String[] names;
    static String[] regNumbers;
    static String[] subjects;
    static String[] classes;
    static double[] marks;

    static int numberOfStudents = 0;

    // Method 1: Teacher login
    public static boolean login() {
        System.out.println("=== PRIME HIGH SCHOOL SYSTEM ===");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (username.equals("teacher") &&
            password.equals("1234")) {
            System.out.println("Login successful!\n");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    // Method 2: Register students
    public static void registerStudents() {
        System.out.print("Enter number of students to register: ");
        numberOfStudents = input.nextInt();
        input.nextLine();

        if (numberOfStudents <= 0) {
            System.out.println("Number of students must be positive.");
            numberOfStudents = 0;
            return;
        }

        names = new String[numberOfStudents];
        regNumbers = new String[numberOfStudents];
        subjects = new String[numberOfStudents];
        classes = new String[numberOfStudents];
        marks = new double[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            names[i] = input.nextLine();

            System.out.print("Enter registration number: ");
            regNumbers[i] = input.nextLine();

            System.out.print("Enter subject: ");
            subjects[i] = input.nextLine();

            System.out.print("Enter class: ");
            classes[i] = input.nextLine();

            marks[i] = -1;
        }

        System.out.println("\nStudents registered successfully!");
    }

    // Method 3: Record students' marks
    public static void recordMarks() {
        if (numberOfStudents == 0) {
            System.out.println("Please register students first.");
            return;
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent: " + names[i]);
            System.out.println("Registration number: " + regNumbers[i]);

            System.out.print("Enter marks (0-100): ");
            double mark = input.nextDouble();
            input.nextLine();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Enter a value from 0 to 100.");
                i--;
            } else {
                marks[i] = mark;
            }
        }

        System.out.println("\nMarks recorded successfully!");
    }

    // Method 4: Display students and marks
    public static void viewStudents() {
        if (numberOfStudents == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        System.out.println("\n=== REGISTERED STUDENTS AND MARKS ===");

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            System.out.println("Name: " + names[i]);
            System.out.println("Registration Number: " + regNumbers[i]);
            System.out.println("Subject: " + subjects[i]);
            System.out.println("Class: " + classes[i]);

            if (marks[i] == -1) {
                System.out.println("Marks: Not recorded");
            } else {
                System.out.println("Marks: " + marks[i]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        if (!login()) {
            System.out.println("Access denied.");
            input.close();
            return;
        }

        int choice;

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Register students");
            System.out.println("2. Record marks");
            System.out.println("3. View students and marks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    registerStudents();
                    break;

                case 2:
                    recordMarks();
                    break;

                case 3:
                    viewStudents();
                    break;

                case 4:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        input.close();
    }
}
