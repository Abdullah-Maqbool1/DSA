public class Task02 {
    public static int evaluate(int x,int n){
        if(n == 0){
            return 1;
        }
        n--;
        return x * evaluate(x,n);
    }
    public static void main(String[] args) {
        System.out.println(evaluate(2,3)); // output: 8
    }
}
