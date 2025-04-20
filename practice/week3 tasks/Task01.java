import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9));

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an element to insert: ");
        int num = sc.nextInt();
        insertElement(num, list);

        System.out.println("Updated List: ");
        System.out.print("Head --> ");
        for (int n : list) {
            System.out.print(n + " --> ");
        }
        System.out.println("End");

    }

    public static void insertElement(int num, LinkedList<Integer> list) {
        int index = 0;
        for (int temp : list) {
            if (temp < num) {
                index++;
            } else {
                list.add(index, num);
                return;
            }
        }
        if (!list.contains(num))
            list.addLast(num);
    }
}