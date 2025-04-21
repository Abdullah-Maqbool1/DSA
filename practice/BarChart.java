import java.util.Arrays;
public class BarChart {
    public static void main(String[] args) {
        String[] subjects = {"Maths", "Science", "History", "English"};
        int[] students = {12, 18, 10, 15};
        int maxStudents = 0;
        for (int s : students) {
            if (s > maxStudents) {
                maxStudents = s;
            }
        }
        for (int i = maxStudents; i > 0; i--) {
            if (i >= 10) {
                System.out.print(i + " |  ");
            } else {
                System.out.print(i + "  |  ");
            }
            for (int j = 0; j < subjects.length; j++) {
                if (students[j] >= i) {
                    System.out.print(" *      ");
                } else {
                    System.out.print("        ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < maxStudents; i++) {
            System.out.print("--");
        }
        System.out.println();
        System.out.print("0  |");
        for (int i = 0; i < subjects.length; i++) {
            System.out.print(subjects[i]+"  ");
        }
    }
}
