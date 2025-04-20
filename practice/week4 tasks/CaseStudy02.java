import java.util.Scanner;

class Action {
    String product, type;
    Action prev, next;

    public Action(String product, String type) {
        this.product = product;
        this.type = type;
    }
}

class Cart {
    Action head = null, current = null;

    void addAction(String product, String type) {
        Action newAction = new Action(product, type);
        if (head == null) {
            head = current = newAction;
        } else {
            current.next = newAction;
            newAction.prev = current;
            current = newAction;
        }
        System.out.println(type + " \"" + product + "\"");
    }

    void undo() {
        if (current != null && current.prev != null) {
            System.out.println("Undo: " + current.product);
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.product);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    void displayCart() {
        System.out.println("Cart History:");
        Action temp = head;
        while (temp != null && temp != current.next) {
            System.out.println(temp.type + ": " + temp.product);
            temp = temp.next;
        }
    }

    void removeProduct(String product) {
        Action temp = head;
        while (temp != null) {
            if (temp.product.equalsIgnoreCase(product)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == current) current = temp.prev;
                System.out.println("Removed \"" + product + "\" from history.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Product not found in history.");
    }
}

public class CaseStudy02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        while (true) {
            System.out.println("\n1. Add Product\n2. Remove Product\n3. Undo\n4. Redo\n5. Display Cart\n6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Product name: ");
                    String prod = sc.nextLine();
                    cart.addAction(prod, "add");
                    break;
                case 2:
                    System.out.print("Enter product to remove: ");
                    cart.removeProduct(sc.nextLine());
                    break;
                case 3:
                    cart.undo();
                    break;
                case 4:
                    cart.redo();
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
