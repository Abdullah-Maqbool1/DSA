
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScenarioBasedTask01 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numbers (separated by spaces): ");
        String[] input = scanner.nextLine().split(" ");
        for (String num : input) {
            numberList.add(Integer.parseInt(num));
        }
        int max = Collections.max(numberList);
        int min = Collections.min(numberList);
        Collections.sort(numberList);

        System.out.println("Sorted List: " + numberList);
        System.out.println("Largest Number: " + max);
        System.out.println("Smallest Number: " + min);

        scanner.close();

    }
}
