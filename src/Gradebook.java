import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Double> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }
}

public class Gradebook {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do { 
            System.out.println("\n=== STUDENT GRADEBOOK MANAGER ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. Show Student Averages");
            System.out.println("4. List All Students");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent();
                case 2: addGrade();
                case 3: showAverages();
                case 4: listStudents();
                case 5: System.out.println("Exiting... Goodbye!");
                default: System.out.println("Invalid choise. Try again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added.");
    }

    static void addGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudent(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter grade (0-100)");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        student.grades.add(grade);
        System.out.println("Grade added.");
    }

    static void showAverages() {
        for (Student s : students) {
            System.out.printf("%s's average: %.2f%n", s.name, s.getAverage());
        }
    }

    static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }

    static Student findStudent(String name) {
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name)) return s;
        }
        return null;
    }
}