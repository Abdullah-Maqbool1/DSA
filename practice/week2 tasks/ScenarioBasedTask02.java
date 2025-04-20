import java.util.Arrays;
import java.util.Scanner;

public class ScenarioBasedTask02 {
    public static void main(String[] args) {
        int[] rollNumbers = {101, 102, 103, 105, 106}; 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n~~~~~~~ Student Records System ~~~~~~~~~");
            System.out.println("1. Insert new roll number");
            System.out.println("2. Search for a roll number");
            System.out.println("3. Delete a roll number");
            System.out.println("4. Count total students");
            System.out.println("5. Find the highest roll number");
            System.out.println("6. Exit");
            System.out.print("~~> Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number to insert: ");
                    int newRoll = scanner.nextInt();
                    System.out.print("Enter position (0 to " + rollNumbers.length + "): ");
                    int position = scanner.nextInt();
                    rollNumbers = insertRollNumber(rollNumbers, newRoll, position);
                    System.out.println("Updated Roll Numbers: " + Arrays.toString(rollNumbers));
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = scanner.nextInt();
                    boolean found = searchRollNumber(rollNumbers, searchRoll);
                    System.out.println(found ? "Student is enrolled." : "Student not found.");
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = scanner.nextInt();
                    rollNumbers = deleteRollNumber(rollNumbers, deleteRoll);
                    System.out.println("Updated Roll Numbers: " + Arrays.toString(rollNumbers));
                    break;

                case 4:
                    System.out.println("Total students enrolled: " + rollNumbers.length);
                    break;

                case 5:
                    int maxRoll = findHighestRollNumber(rollNumbers);
                    System.out.println("Highest Roll Number: " + maxRoll);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static int[] insertRollNumber(int[] arr, int newRoll, int position) {
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid position!");
            return arr;
        }

        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == position) {
                newArr[i] = newRoll;
            } else {
                newArr[i] = arr[j++];
            }
        }
        return newArr;
    }

    public static boolean searchRollNumber(int[] arr, int roll) {
        for (int num : arr) {
            if (num == roll) {
                return true;
            }
        }
        return false;
    }

    public static int[] deleteRollNumber(int[] arr, int roll) {
        int count = 0;
        for (int num : arr) {
            if (num == roll) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Roll number not found!");
            return arr;
        }

        int[] newArr = new int[arr.length - count];
        int index = 0;
        for (int num : arr) {
            if (num != roll) {
                newArr[index++] = num;
            }
        }
        return newArr;
    }

    public static int findHighestRollNumber(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
