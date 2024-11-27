import java.io.*;
import java.util.*;

class Student {
    String name;
    int rollNumber;
    double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Marks: " + marks;
    }
}

public class CSVHandler {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = "students.csv"; // Specify the CSV file name
        readCSV(fileName);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Search Student\n2. Update Marks\n3. Delete Student\n4. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter roll number to search: ");
                    int roll = scanner.nextInt();
                    searchStudent(roll);
                    break;
                case 2:
                    System.out.print("Enter roll number to update: ");
                    roll = scanner.nextInt();
                    System.out.print("Enter new marks: ");
                    double marks = scanner.nextDouble();
                    updateStudent(roll, marks);
                    break;
                case 3:
                    System.out.print("Enter roll number to delete: ");
                    roll = scanner.nextInt();
                    deleteStudent(roll);
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    static void readCSV(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[2])));
            }
        }
    }

    static void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void updateStudent(int rollNumber, double marks) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                student.marks = marks;
                System.out.println("Updated: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent(int rollNumber) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().rollNumber == rollNumber) {
                iterator.remove();
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
