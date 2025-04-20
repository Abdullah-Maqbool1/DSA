import java.util.LinkedList;
import java.util.Scanner;

class CustomerServiceQueue {
    protected LinkedList<String> queue;

    public CustomerServiceQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(String customerName) {
        queue.addLast(customerName);
        System.out.println("Customer added to the queue Successfully!");
    }

    public void dequeue() {
        if (queue.isEmpty())
            System.out.println("Error: Queue is empty!");
        else {
            System.out.println("Customer ( " + queue.getFirst() + ") served Successfully!");
            queue.poll();
        }
    }

    public void displayQueue() {
        if (queue.isEmpty())
            System.out.println("Error: Queue is empty!");
        else
            System.out.println(queue);
    }
}

public class Task02 {
    public static void main(String[] args) {
        CustomerServiceQueue queue = new CustomerServiceQueue();
        System.out.println("~~~~~ Welcome to Customer Service centre: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(" 1) Enqueue(add a customer)");
            System.out.println(" 2) Dequeue(serve a customer)");
            System.out.println(" 3) View Queue of customers");
            System.out.println(" 4) Exit");
            System.out.println("~~ Select an option (1,2,3 or 4): ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter customer name: ");
                    String name = sc.nextLine();
                    queue.enqueue(name);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Thanks for visiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid input, please try again!");
                    break;
            }
        }
    }
}