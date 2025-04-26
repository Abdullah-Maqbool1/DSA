// L1F23BSSE0391 - Abdullah Maqbool - P4

import java.util.LinkedList;
import java.util.Scanner;

class Customer {
    String name;
    String issue;
    String priority;

    public Customer(String name, String issue, String priority) {
        this.name = name;
        this.issue = issue;
        this.priority = priority;
    }
}

class HelpDesk {
    LinkedList<Customer> queue = new LinkedList<>();

    public void enqueue(String name, String issue, String priority) {
        Customer newCustomer = new Customer(name, issue, priority);
        if (priority.equalsIgnoreCase("urgent")) {
            queue.addFirst(newCustomer);
        } else {
            queue.addLast(newCustomer);
        }
        System.out.println("Customer added successfully.");
    }

    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue to serve.");
            return;
        }
        Customer servedCustomer = queue.removeFirst();
        System.out.println(" Serving Customer: " + servedCustomer.name + " \n Issue: " + servedCustomer.issue + " \n Priority: " + servedCustomer.priority);
    }

    public void peek() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Customer nextCustomer = queue.peekFirst();
        System.out.println(" Next Customer: " + nextCustomer.name + " \n Issue: " + nextCustomer.issue + " \n Priority: " + nextCustomer.priority);
    }

    public void isEmpty() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("There are customers waiting in the queue.");
        }
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("No customers are currently in the queue.");
            return;
        }
        System.out.println("Customers currently in queue:");
        int count = 1;
        for (Customer c : queue) {
            System.out.println(count++ + ") " + c.name + " ~ Issue: " + c.issue + " ~ Priority: " + c.priority);
        }
    }
}

public class Scenario02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HelpDesk HD = new HelpDesk();

        while (true) {
            System.out.println(" |======================================================|");
            System.out.println(" |                    HELPDESK SYSTEM                   |");
            System.out.println(" |======================================================|");
            System.out.println(" |                   (1) Add Customer                   |");
            System.out.println(" |                   (2) Serve Next Customer            |");
            System.out.println(" |                   (3) View Next Customer             |");
            System.out.println(" |                   (4) Check if Queue is Empty        |");
            System.out.println(" |                   (5) Display All Customers          |");
            System.out.println(" |                   (6) Exit                           |");
            System.out.println(" |------------------------------------------------------|");

            System.out.print("\n Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Issue Description: ");
                    String issue = sc.nextLine();
                    System.out.print("Enter Priority (normal/urgent): ");
                    String priority = sc.nextLine();
                    HD.enqueue(name, issue, priority);
                    break;
                case 2:
                    HD.dequeue();
                    break;
                case 3:
                    HD.peek();
                    break;
                case 4:
                    HD.isEmpty();
                    break;
                case 5:
                    HD.displayQueue();
                    break;
                case 6:
                    System.out.println("Thanks for using Helpdesk System, Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice,Pls try again.");
            }
        }
    }
}
