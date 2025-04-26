// L1F23BSSE0391 - Abdullah Maqbool - P4


import java.util.Scanner;
import java.util.Stack;

class TextEditor {
     Stack<String> undoStack = new Stack<>();
     Stack<String> redoStack = new Stack<>();
     StringBuilder currentText = new StringBuilder();

    public void performAction(String type, String text) {
        if (type.equalsIgnoreCase("insert")) {
            currentText.append(text);
            undoStack.push("insert:" + text);
        } else if (type.equalsIgnoreCase("delete")) {
            int len = Integer.parseInt(text); // converting text(num) to integer
            if (len > currentText.length()) {
                len = currentText.length();
            }
            String deleted = currentText.substring(currentText.length() - len);
            currentText.delete(currentText.length() - len, currentText.length());
            undoStack.push("delete:" + deleted);
        } else {
            System.out.println("Unknown action type.");
            return;
        }
        redoStack.clear();
        System.out.println("Action performed successfully");
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        String action = undoStack.pop();
        redoStack.push(action);

        String[] parts = action.split(":");
        if (parts[0].equals("insert")) {
            currentText.delete(currentText.length() - parts[1].length(), currentText.length());
        } else if (parts[0].equals("delete")) {
            currentText.append(parts[1]);
        }
        System.out.println("Undo successful.");
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }
        String action = redoStack.pop();
        undoStack.push(action);

        String[] parts = action.split(":");
        if (parts[0].equals("insert")) {
            currentText.append(parts[1]);
        } else if (parts[0].equals("delete")) {
            currentText.delete(currentText.length() - parts[1].length(), currentText.length());
        }
        System.out.println("Redo successful.");
    }

    public void showHistory() {
        System.out.println("Undo History:");
        for (String act : undoStack) {
            System.out.println(act);
        }
        System.out.println("Current Text: " + currentText.toString());
    }
}

public class Scenario01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor TE = new TextEditor();
        while (true) {
            System.out.println(" |======================================================|");
            System.out.println(" |                      TEXT EDITOR                     |");
            System.out.println(" |======================================================|");
            System.out.println(" |                   (1) Insert Text                    |");
            System.out.println(" |                   (2) Delete Text                    |");
            System.out.println(" |                   (3) Undo                           |");
            System.out.println(" |                   (4) Redo                           |");
            System.out.println(" |                   (5) Show History                   |");
            System.out.println(" |                   (6) Exit                           |");
            System.out.println(" |------------------------------------------------------|");

            System.out.print("\n Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to insert: ");
                    String text = sc.nextLine();
                    TE.performAction("insert", text);
                    break;
                case 2:
                    System.out.print("Enter number of characters to delete: ");
                    String num = sc.nextLine();
                    TE.performAction("delete", num);
                    break;
                case 3:
                    TE.undo();
                    break;
                case 4:
                    TE.redo();
                    break;
                case 5:
                    TE.showHistory();
                    break;
                case 6:
                    System.out.println("Thanks for using text editor, Exiting Text Editor....");
                    return;
                default:
                    System.out.println("Invalid choice.Pls Try Again");
            }
        }
    }
}
