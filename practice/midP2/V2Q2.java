import java.util.LinkedList;
import java.util.ListIterator;

// VIP Guest Node (Using Java's LinkedList)
class VIPGuest {
    String guestName;
    String attraction;

    VIPGuest(String guestName, String attraction) {
        this.guestName = guestName;
        this.attraction = attraction;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + " | Attraction: " + attraction;
    }
}

// VIP Guest Trail using LinkedList
class VIPGuestTrail {
    LinkedList<VIPGuest> trail = new LinkedList<>();

    void addVIPGuest(String name, String attraction) {
        trail.add(new VIPGuest(name, attraction));
        System.out.println("Added VIP Guest: " + name);
    }

    void removeVIPGuest(String name) {
        for (VIPGuest guest : trail) {
            if (guest.guestName.equalsIgnoreCase(name)) {
                trail.remove(guest);
                System.out.println("Removed VIP Guest: " + name);
                return;
            }
        }
        System.out.println("Guest not found: " + name);
    }

    void displayForward() {
        System.out.println("VIP Guests (Forward):");
        for (VIPGuest guest : trail) {
            System.out.println(guest);
        }
    }

    void displayBackward() {
        System.out.println("VIP Guests (Backward):");
        ListIterator<VIPGuest> iterator = trail.listIterator(trail.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}

// Node class for circular queue
class RiderNode {
    String name;
    RiderNode next;

    RiderNode(String name) {
        this.name = name;
        this.next = null;
    }
}

// Circular Queue for Roller Coaster
class RollerCoasterQueue {
    private RiderNode tail = null;

    void addRider(String name) {
        RiderNode newNode = new RiderNode(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // point to itself
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Added Rider: " + name);
    }

    void removeRider() {
        if (tail == null) {
            System.out.println("Queue is empty.");
            return;
        }

        RiderNode head = tail.next;

        if (head == tail) {
            System.out.println("Removed Rider: " + head.name);
            tail = null;
        } else {
            System.out.println("Removed Rider: " + head.name);
            tail.next = head.next;
        }
    }

    void displayRiders() {
        if (tail == null) {
            System.out.println("No riders in the queue.");
            return;
        }

        System.out.println("Current Riders in Queue:");
        RiderNode current = tail.next;
        do {
            System.out.println("Rider: " + current.name);
            current = current.next;
        } while (current != tail.next);
    }
}

// Main Class
public class V2Q2 {
    public static void main(String[] args) {
        // VIP Guest Trail
        VIPGuestTrail vipTrail = new VIPGuestTrail();
        vipTrail.addVIPGuest("Alice", "Ferris Wheel");
        vipTrail.addVIPGuest("Bob", "Haunted House");
        vipTrail.addVIPGuest("Charlie", "Water Slide");
        vipTrail.addVIPGuest("Diana", "Roller Coaster");

        System.out.println();
        vipTrail.displayForward();
        System.out.println();
        vipTrail.displayBackward();
        System.out.println();

        vipTrail.removeVIPGuest("Charlie");
        System.out.println();
        vipTrail.displayForward();

        // Roller Coaster Queue
        System.out.println("\n--- Roller Coaster Queue ---");
        RollerCoasterQueue coasterQueue = new RollerCoasterQueue();
        coasterQueue.addRider("R1");
        coasterQueue.addRider("R2");
        coasterQueue.addRider("R3");
        coasterQueue.addRider("R4");
        coasterQueue.addRider("R5");

        coasterQueue.removeRider();
        coasterQueue.removeRider();

        System.out.println();
        coasterQueue.displayRiders();
    }
}
