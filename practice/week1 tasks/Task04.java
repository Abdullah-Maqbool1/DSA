import java.util.PriorityQueue;
import java.util.Scanner;

class Client implements Comparable<Client> {
    protected String fullName;
    protected String passCategory;

    public Client(String fullName, String passCategory) {
        this.fullName = fullName;
        this.passCategory = passCategory;
    }

    @Override
    public int compareTo(Client other) {
        if (this.passCategory.equals(other.passCategory)) {
            return this.fullName.compareTo(other.fullName);
        }
        return this.passCategory.equals("VIP") ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Client--->Name: '" + fullName + "', Pass Type: '" + passCategory + "'";
    }
}

public class Task04 {
    public static void main(String[] args) {
        PriorityQueue<Client> serviceQueue = new PriorityQueue<>();
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add Client");
            System.out.println("2) Serve Client");
            System.out.println("3) Show Queue");
            System.out.println("4) Exit");
            System.out.print("Select an option(1,2,3 or 4): ");
            int selection = inputScanner.nextInt();
            inputScanner.nextLine();

            switch (selection) {
                case 1:
                    addClient(inputScanner, serviceQueue);
                    break;
                case 2:
                    serveClient(serviceQueue);
                    break;
                case 3:
                    showQueue(serviceQueue);
                    break;
                case 4:
                    System.out.println("Closing the system...");
                    inputScanner.close();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void addClient(Scanner inputScanner, PriorityQueue<Client> serviceQueue) {
        System.out.print("Enter Client Name: ");
        String fullName = inputScanner.nextLine();
        String passCategory;

        do {
            System.out.print("Enter Pass Type (VIP/Regular): ");
            passCategory = inputScanner.nextLine();
            if (!passCategory.equalsIgnoreCase("VIP") && !passCategory.equalsIgnoreCase("Regular")) {
                System.out.println("Invalid pass type. Please enter 'VIP' or 'Regular'.");
            }
        } while (!passCategory.equalsIgnoreCase("VIP") && !passCategory.equalsIgnoreCase("Regular"));

        serviceQueue.add(new Client(fullName, passCategory));
        System.out.println("Client added to the queue.");
    }

    private static void serveClient(PriorityQueue<Client> serviceQueue) {
        if (!serviceQueue.isEmpty()) {
            Client servedClient = serviceQueue.poll();
            System.out.println("Served: " + servedClient);
        } else {
            System.out.println("No clients available for service.");
        }
    }

    private static void showQueue(PriorityQueue<Client> serviceQueue) {
        if (!serviceQueue.isEmpty()) {
            System.out.println("Current Queue: " + serviceQueue);
        } else {
            System.out.println("The queue is empty.");
        }
    }
}

