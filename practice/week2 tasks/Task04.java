import java.util.ArrayList;
import java.util.Arrays;

public class Task04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Strawberry", "Date"));
        System.out.println("Original List: " + list);

        updateElement(list, 2, "Watermelon");
        System.out.println("Updated List: " + list);
    }

    public static void updateElement(ArrayList<String> list, int index, String newValue) {
        if (index >= 0 && index < list.size()) {
            list.set(index, newValue);
        } else {
            System.out.println("Invalid Index!");
        }
    }
}
