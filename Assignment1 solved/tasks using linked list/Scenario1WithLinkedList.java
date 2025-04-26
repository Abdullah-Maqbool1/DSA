import java.util.LinkedList;
import java.util.Scanner;

class Order {
    int orderId;
    double totalAmount;

    public Order(int orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public void printOrderDetails() {
        System.out.println("Order Id: " + orderId);
        System.out.println("Total Order Amount: " + totalAmount);
    }
}

class OrderManagementSystem {
    LinkedList<Order> ordersList;

    public OrderManagementSystem() {
        ordersList = new LinkedList<>();
    }

    public void addOrder(Order order) { // ~~> take O(1) time complexity because NO shifting required!
        ordersList.addFirst(order); // inserting at first (implementing FIFO)
        System.out.println("Order Added Successfully!");
    }

    public void processOrder() { // ~~> take O(1) time complexity!
        if (ordersList.isEmpty()) {
            System.out.println("Error: List is empty!");
        } else {
            ordersList.getLast().printOrderDetails();
            ordersList.removeLast();  // removing from the last of the list (implementing FIFO)
            System.out.println("Order Processed Successfully!");
        }
    }

    public void printRecentOrderDetails() { // ~~> take O(1) time complexity
        if (ordersList.isEmpty()) {
            System.out.println("Error: List is empty!");
        } else {
            ordersList.getFirst().printOrderDetails();
        }
    }
}

public class Scenario1WithLinkedList {
    public static void main(String[] args) {
        OrderManagementSystem OMS = new OrderManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println(" \t ~~ Welcome to Order Management System(OMS) ~~ ");
        while (true) {
            System.out.println("\n 1) Store Customer Order");
            System.out.println(" 2) Process Order");
            System.out.println(" 3) Retrieve the most recent order details");
            System.out.println(" 4) Exit");
            System.out.println("\t Select an option (1,2,3 or 4)");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Order id: ");
                    int orderId = sc.nextInt();
                    System.out.println("Enter total order amount: ");
                    double totalAmount = sc.nextDouble();
                    OMS.addOrder(new Order(orderId, totalAmount));
                    break;
                case 2:
                    System.out.println("Details of the Order going to be processed: ");
                    OMS.processOrder();
                    break;
                case 3:
                    System.out.println("Details of the most recent order: ");
                    OMS.printRecentOrderDetails();
                    break;
                case 4:
                    System.out.println(" \t ~~ Thanks for using Order Management System(OMS)! ~~");
                    return;
            }
        }
    }
}
