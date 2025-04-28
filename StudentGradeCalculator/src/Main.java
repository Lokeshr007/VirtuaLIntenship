import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAOImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Student Grade Calculator ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter mark for subject " + (i + 1) + ": ");
            marks[i] = Integer.parseInt(scanner.nextLine());
        }
        Student student = new Student(0, name, marks);
        studentDAO.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = studentDAO.getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new name (" + student.getName() + "): ");
        String name = scanner.nextLine();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter new mark for subject " + (i + 1) + ": ");
            marks[i] = Integer.parseInt(scanner.nextLine());
        }
        student = new Student(id, name, marks);
        studentDAO.updateStudent(student);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentDAO.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }

    private static void viewAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                               ", Name: " + student.getName() +
                               ", Total: " + student.getTotal() +
                               ", Average: " + student.getAverage() +
                               ", Grade: " + student.getGrade());
        }
    }
}