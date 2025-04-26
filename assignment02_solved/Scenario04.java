// L1F23BSSE0391 - Abdullah Maqbool - P4

import java.util.*;

class Aircraft {
    String flightNumber;
    String destination;
    String priority;

    public Aircraft(String flightNumber, String destination, String priority) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.priority = priority;
    }
}

class RunwaySystem {
    Queue<Aircraft> queue = new LinkedList<>();
    Set<String> flightNumbers = new HashSet<>();

    public void addFlight(String flightNumber, String destination, String priority) {
        if (flightNumbers.contains(flightNumber)) {
            System.out.println("Error: Flight number already exists!");
            return;
        }
        Aircraft newFlight = new Aircraft(flightNumber, destination, priority);

        if (priority.equalsIgnoreCase("urgent")) {
            LinkedList<Aircraft> tempList = new LinkedList<>(queue);
            tempList.addFirst(newFlight);
            queue = new LinkedList<>(tempList);
        } else {
            queue.add(newFlight);
        }

        flightNumbers.add(flightNumber);
        System.out.println("Flight added successfully.");
    }

    public void authorizeTakeoff() {
        if (queue.isEmpty()) {
            System.out.println("No flights waiting for takeoff.");
            return;
        }
        Aircraft flight = queue.poll();
        flightNumbers.remove(flight.flightNumber);
        System.out.println("Flight " + flight.flightNumber + " to " + flight.destination + " has taken off!");
    }

    public void peekNextFlight() {
        if (queue.isEmpty()) {
            System.out.println("No flights in the queue.");
            return;
        }
        Aircraft next = queue.peek();
        System.out.println("Next Flight: " + next.flightNumber + " ~ Destination: " + next.destination + " ~ Priority: " + next.priority);
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("No flights waiting in the queue.");
            return;
        }
        System.out.println("Flights waiting in queue:");
        int count = 1;
        for (Aircraft f : queue) {
            System.out.println(count++ + ") " + f.flightNumber + " -> " + f.destination + " (" + f.priority + ")");
        }
    }
}

public class Scenario04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RunwaySystem RS = new RunwaySystem();

        while (true) {
            System.out.println(" |======================================================|");
            System.out.println(" |                   AIRCRAFT RUNWAY SYSTEM             |");
            System.out.println(" |======================================================|");
            System.out.println(" |                   (1) Add Flight                     |");
            System.out.println(" |                   (2) Authorize Takeoff              |");
            System.out.println(" |                   (3) View Next Flight               |");
            System.out.println(" |                   (4) Display All Flights            |");
            System.out.println(" |                   (5) Exit                           |");
            System.out.println(" |------------------------------------------------------|");

            System.out.print("\n Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight Number: ");
                    String flightNumber = sc.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = sc.nextLine();
                    System.out.print("Enter Priority (normal/urgent): ");
                    String priority = sc.nextLine();
                    RS.addFlight(flightNumber, destination, priority);
                    break;
                case 2:
                    RS.authorizeTakeoff();
                    break;
                case 3:
                    RS.peekNextFlight();
                    break;
                case 4:
                    RS.displayQueue();
                    break;
                case 5:
                    System.out.println("Thanks for using Aircraft Runway System, Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice,pls try again.");
            }
        }
    }
}
