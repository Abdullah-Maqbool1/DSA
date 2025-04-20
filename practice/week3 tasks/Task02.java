import java.util.Arrays;
import java.util.LinkedList;

public class Task02 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.print("Before Reversing: ");
        displayList(list);
        reverse(list);
        System.out.print("After Reversing: ");
        displayList(list);
    }

    public static void reverse(LinkedList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void displayList(LinkedList<Integer> list) {
        System.out.print("Head --> ");
        for (int n : list) {
            System.out.print(n + " --> ");
        }
        System.out.println("End");
    }
}
