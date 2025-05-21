public class Task01 {
    public static int findSum(int n){
        if(n < 0){
            System.out.println("Invalid input! Please enter a number greater than zero!");
            return -1;
        }
        int sum = 0;
        if(n == 0){
            return sum;
        }
        return n + findSum(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(findSum(5)); // output: 15
    }
}
