import java.util.LinkedList;
import java.util.ListIterator;

// VIP Passenger class
class VIPPassenger {
    String passengerName;
    String loungeName;

    public VIPPassenger(String passengerName, String loungeName) {
        this.passengerName = passengerName;
        this.loungeName = loungeName;
    }

    public void display() {
        System.out.println("Passenger: " + passengerName + ", Lounge: " + loungeName);
    }
}

// VIP Lounge Management using LinkedList
class VIPLoungeManagement {
    LinkedList<VIPPassenger> loungeTrail = new LinkedList<>();

    public void addPassenger(String name, String lounge) {
        loungeTrail.add(new VIPPassenger(name, lounge));
        System.out.println(name + " added to lounge: " + lounge);
    }

    public void removePassenger(String name) {
        for (VIPPassenger p : loungeTrail) {
            if (p.passengerName.equals(name)) {
                loungeTrail.remove(p);
                System.out.println(name + " removed from the lounge trail.");
                return;
            }
        }
        System.out.println(name + " not found in lounge trail.");
    }

    public void displayForward() {
        System.out.println("VIP Passengers (Forward):");
        for (VIPPassenger p : loungeTrail) {
            p.display();
        }
    }

    public void displayBackward() {
        System.out.println("VIP Passengers (Backward):");
        ListIterator<VIPPassenger> it = loungeTrail.listIterator(loungeTrail.size());
        while (it.hasPrevious()) {
            it.previous().display();
        }
    }
}

// Node class for Circular Queue
class CircularNode {
    String name;
    CircularNode next;

    public CircularNode(String name) {
        this.name = name;
        this.next = null;
    }
}

// Circular Flight Boarding Queue
class FlightBoardingQueue {
    CircularNode front = null;
    CircularNode rear = null;

    public void addPassenger(String name) {
        CircularNode newNode = new CircularNode(name);
        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        System.out.println(name + " added to the flight boarding queue.");
    }

    public void removePassenger() {
        if (front == null) {
            System.out.println("No passengers to remove.");
            return;
        }
        String removedName = front.name;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        System.out.println(removedName + " boarded and removed from the queue.");
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Flight boarding queue is empty.");
            return;
        }
        System.out.println("Passengers in Flight Boarding Queue:");
        CircularNode temp = front;
        do {
            System.out.println("Passenger: " + temp.name);
            temp = temp.next;
        } while (temp != front);
    }
}

// Main class to perform all tasks
public class V1Q2 {
    public static void main(String[] args) {
        // VIP Lounge Trail Tasks
        VIPLoungeManagement vip = new VIPLoungeManagement();
        vip.addPassenger("Alice", "Lounge A");
        vip.addPassenger("Bob", "Lounge B");
        vip.addPassenger("Charlie", "Lounge C");
        vip.addPassenger("Diana", "Lounge D");

        vip.displayForward();
        vip.displayBackward();

        vip.removePassenger("Charlie");

        vip.displayForward();

        // Flight Boarding Queue Tasks
        FlightBoardingQueue fbq = new FlightBoardingQueue();
        fbq.addPassenger("P1");
        fbq.addPassenger("P2");
        fbq.addPassenger("P3");
        fbq.addPassenger("P4");
        fbq.addPassenger("P5");

        fbq.removePassenger();
        fbq.removePassenger();

        fbq.displayQueue();
    }
}
