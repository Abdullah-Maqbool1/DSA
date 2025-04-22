import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesisChecker {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    break;
            }
            if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    break;
            }
            if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //   String expression = "{[a+b[(a*c)]]}"
        //  System.out.println(isBalanced(expression));


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an expression (or block of code) to check that parenthesis are balanced or not: ");
        String expression = sc.nextLine();
        System.out.println("Given Expression: " + expression);
        System.out.println("Balanced Parenthesis? :" + isBalanced(expression));
    }
}
