public class Task04 {
    public static String reverse(String str){
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverse(str)); // output: olleh
    }
}
