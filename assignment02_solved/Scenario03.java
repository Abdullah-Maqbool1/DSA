// L1F23BSSE0391 - Abdullah Maqbool - P4


import java.util.Scanner;
import java.util.Stack;

class PostfixEvaluator {
    Stack<Integer> stack = new Stack<>();

    public int evaluate(String expression) {
        String[] tokens = expression.trim().split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Error: Not enough operands.");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Error: Invalid token - " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Error: Invalid postfix expression.");
        }

        return stack.pop();
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero not possible.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
public class Scenario03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostfixEvaluator PE = new PostfixEvaluator();

        while (true) {
            System.out.println(" |======================================================|");
            System.out.println(" |                POSTFIX EXPRESSION EVALUATOR          |");
            System.out.println(" |------------------------------------------------------|");
            System.out.println(" |                   (1) Evaluate Expression            |");
            System.out.println(" |                   (2) Exit                           |");
            System.out.println(" |------------------------------------------------------|");

            System.out.print("\n Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a postfix expression: ");
                    String expression = sc.nextLine();
                    try {
                        int result = PE.evaluate(expression);
                        System.out.println("Result of the expression: " + result);
                    } catch (Exception e) {
                        System.out.println("Error evaluating expression: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Thanks for using Postfix Evaluator, Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, Pls try again.");
            }
        }
    }
}
