import java.util.LinkedList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    int gradePoints; // out of 100.

    public Student(String name, int rollNumber, int gradePoints) {
        this.name = name;
        this.gradePoints = gradePoints;
        this.rollNumber = rollNumber;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade points(out of 100):" + gradePoints);
        System.out.println("---------------------------------------");
    }
}

public class ScenarioBasedTask01 {
    public static void main(String[] args) {
        LinkedList<Student> enrollments = new LinkedList<>();
        enrollments.add(new Student("A", 1, 90));
        enrollments.add(new Student("C", 3, 99));
        enrollments.add(new Student("B", 4, 44));
        enrollments.add(new Student("L", 2, 55));

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1) Add a new Student");
            System.out.println("2) Remove a Student");
            System.out.println("3) Search a Student");
            System.out.println("4) Sort Students List Alphabetically");
            System.out.println("5) Find Student with Highest Grade");
            System.out.println("6) Exit.");

            System.out.println("Select: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    String name;
                    int gradePoints, rollNumber;
                    System.out.println("Enter Student Name:");
                    name = sc.nextLine().trim();
                    System.out.println("Enter Student RollNumber: ");
                    rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Grade Points(out of 100)");
                    gradePoints = sc.nextInt();
                    sc.nextLine();
                    enrollments.add(new Student(name, rollNumber, gradePoints));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("Enter student roll number to remove: ");
                    int rollNumberToDelete = sc.nextInt();
                    sc.nextLine();
                    for (Student s : enrollments) {
                        if (s.rollNumber == rollNumberToDelete) {
                            enrollments.remove(s);
                            System.out.println("Student with roll number: " + s.rollNumber + " removed successfully");
                            return;
                        }
                    }
                    System.out.println("Student not found!");
                    break;
                case 3:
                    System.out.println("Enter student name: ");
                    String nameToSearch = sc.nextLine().trim();
                    sc.nextLine();
                    for (Student s : enrollments) {
                        if (s.name.equals(nameToSearch)) {
                            s.display();
                            return;
                        }
                    }
                    System.out.println("Student not found!");
                    break;
                case 4:
                    System.out.println("Students sorted according to their names alphabetically:");
                    int n = enrollments.size();
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (enrollments.get(j).name.compareTo(enrollments.get(j + 1).name) > 0) {
                                // Swap students[j] and students[j + 1]
                                Student temp = enrollments.get(j);
                                enrollments.set(j, enrollments.get(j + 1));
                                enrollments.set(j + 1, temp);
                            }
                        }
                    }
                    for (Student s : enrollments) {
                        s.display();
                    }
                    break;
                case 5:
                    System.out.println("Student with the highest grade point:");
                    Student highestGradeStudent = enrollments.getFirst();
                    for (Student s : enrollments) {
                        if (s.gradePoints > highestGradeStudent.gradePoints) {
                            highestGradeStudent = s;
                        }
                    }
                    highestGradeStudent.display();
                    break;
                case 6:
                    System.out.println("Exiting.");
                    return;
            }

        }
    }
}
