import java.util.Arrays;

public class Task02 {
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            mergedArr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            mergedArr[k++] = arr2[j++];
        }
        return mergedArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40};
        int[] arr2 = {11, 22, 33, 44};
        int[] mergedArr = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergedArr));
    }
}

