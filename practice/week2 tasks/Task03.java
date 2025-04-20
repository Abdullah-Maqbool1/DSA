import java.util.ArrayList;
import java.util.Arrays;

public class Task03 {

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedArrList = new ArrayList<>(list1);
        mergedArrList.addAll(list2);
        return mergedArrList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> arrList2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        ArrayList<Integer> mergedArrList = merge(arrList1, arrList2);
        System.out.println(mergedArrList);
    }
}
