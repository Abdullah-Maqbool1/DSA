import java.util.Stack;

class Action {
    String type; // insert or delete
    String content;

    public Action(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String toString() {
        return type + ": " + content;
    }
}

class TextEditor {
    Stack<Action> actionStack = new Stack<>();

    public void performAction(String type, String content) {
        actionStack.push(new Action(type, content));
    }

    public void undo() {
        if (!actionStack.isEmpty()) {
            Action lastAction = actionStack.pop();
            System.out.println("Undo -> " + lastAction);
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public void peekCurrentAction() {
        if (!actionStack.isEmpty()) {
            System.out.println("Current: " + actionStack.peek());
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public void displayActions() {
        if (actionStack.isEmpty()) {
            System.out.println("No actions performed.");
            return;
        }
        System.out.println("Action History:");
        for (Action a : actionStack) {
            System.out.println(a);
        }
    }
}

public class TextEditorUndo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        System.out.println("\t\n ~~~WELCOME TO YOUR TEXT EDITOR~~~");
        editor.performAction("insert", "Hello");
        editor.performAction("insert", "World");
        editor.performAction("delete", "o");
        System.out.println("\nPeeking current action:");
        editor.peekCurrentAction();
        System.out.println("\nAll Actions:");
        editor.displayActions();
        System.out.println("\nUndoing last action:");
        editor.undo();
        System.out.println("\nAfter Undo:");
        editor.displayActions();
    }
}

