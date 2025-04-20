import java.util.Arrays;

public class Task01 {
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int temp;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Before Reversing: ");
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println("After Reversing: ");
        System.out.println(Arrays.toString(arr));
    }
}
