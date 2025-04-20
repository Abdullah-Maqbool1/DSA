import java.util.HashMap;
import java.util.Scanner;

class CustomerTicketsSet {
    protected HashMap<String, String> ticketsSet;
    Scanner sc = new Scanner(System.in);

    public CustomerTicketsSet() {
        ticketsSet = new HashMap<>();
    }

    public void add(String id, String type) {
        ticketsSet.put(id, type);
        System.out.println("Ticket info added Successfully!");
    }

    public void update(String id) {
        if (ticketsSet.containsKey(id)) {
            System.out.println("Enter new type(VIP or REGULAR): ");
            String newType = sc.nextLine();
            ticketsSet.replace(id, newType);
            System.out.println("Ticket type updated Successfully!");
        } else
            System.out.println("Error: Ticket not found!");
    }

    public void delete(String id) {
        if (ticketsSet.containsKey(id)) {
            ticketsSet.remove(id);
            System.out.println("Ticket deleted Successfully!");
        } else
            System.out.println("Error: Ticket not found!");
    }

    public void displayTickets() {
        if (ticketsSet.isEmpty())
            System.out.println("No tickets found!");
        else
            System.out.println(ticketsSet);
    }
}

public class Task03 {
    public static void main(String[] args) {
        CustomerTicketsSet ticketsSet = new CustomerTicketsSet();
        System.out.println("~~~~~ Welcome to Customer Ticket centre: ");
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(" 1) Add a ticket");
            System.out.println(" 2) Update ticket type");
            System.out.println(" 3) View Customer Tickets");
            System.out.println(" 4) Delete a ticket");
            System.out.println(" 5) Exit");
            System.out.println("~~ Select an option (1,2,3,4 or 5): ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter ticket id: ");
                    String id = sc.nextLine();
                    System.out.println("Enter ticket type(VIP or REGULAR): ");
                    String type = sc.nextLine();
                    ticketsSet.add(id, type);
                    break;
                case 2:
                    System.out.println("Enter ticket id to update: ");
                    String updateId = sc.nextLine();
                    ticketsSet.update(updateId);
                    break;
                case 3:
                    ticketsSet.displayTickets();
                    break;
                case 4:
                    System.out.println("Enter ticket id to delete: ");
                    String deleteId = sc.nextLine();
                    ticketsSet.delete(deleteId);
                    break;
                case 5:
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
