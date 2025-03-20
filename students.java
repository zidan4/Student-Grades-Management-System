import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private String name;
    private int id;
    private ArrayList<Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id + " | Name: " + name + " | Average Grade: " + getAverageGrade());
    }
}

// Student Management System
class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int id) {
        students.add(new Student(name, id));
        System.out.println("Student added successfully!");
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.id == id) return student;
        }
        return null;
    }

    public void displayAllStudents() {
        System.out.println("\nStudent Records:");
        for (Student student : students) {
            student.displayInfo();
        }
    }
}

// Main class
public class GradeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();

        while (true) {
            System.out.println("\n1. Add Student\n2. Add Grade\n3. View Students\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Student Name: ");
                scanner.nextLine();  // Consume newline
                String name = scanner.nextLine();
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                sm.addStudent(name, id);
            } else if (choice == 2) {
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                Student student = sm.findStudent(id);
                if (student != null) {
                    System.out.print("Enter Grade: ");
                    int grade = scanner.nextInt();
                    student.addGrade(grade);
                    System.out.println("Grade added!");
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 3) {
                sm.displayAllStudents();
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
