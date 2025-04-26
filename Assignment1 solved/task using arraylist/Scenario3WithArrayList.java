import java.util.ArrayList;
import java.util.Scanner;

class SeatBookingSystem {
    ArrayList<String> seats;

    public SeatBookingSystem(int totalSeats) {
        this.seats = new ArrayList<>(totalSeats);
        for (int i = 0; i < totalSeats; i++) {
            seats.add(null);
        }
    }

    public void bookSeat(int seatNumber, String passengerName) { // time complexity - O(1)
        if (seatNumber >= 0 && seatNumber < seats.size()) {
            if (seats.get(seatNumber) == null) {
                seats.set(seatNumber, passengerName);
                System.out.println("Seat number " + seatNumber + " booked successfully!");
            } else {
                System.out.println("Sorry, Seat is already booked!");
            }
        } else {
            System.out.println("Error: Invalid seat number.");
        }
    }

    public void cancelSeat(int seatNumber) { // time complexity - O(1)
        if (seatNumber >= 0 && seatNumber < seats.size()) {
            if (seats.get(seatNumber) != null) {
                seats.set(seatNumber, null);
                System.out.println("Seat number " + seatNumber + " canceled successfully!");
            } else {
                System.out.println("This seat was never booked before!");
            }
        } else {
            System.out.println("Error: Invalid seat number.");
        }
    }

    public void searchAvailableSeats() { // time complexity - O(n)
        System.out.print("Available seats are (seat number): ");
        boolean allSeatsBooked = true;
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i) == null) {
                System.out.print(i + ", ");
                allSeatsBooked = false;
            }
        }
        if (allSeatsBooked) {
            System.out.println("No seats available!");
        }
    }
}

public class Scenario3WithArrayList {
    public static void main(String[] args) {
        SeatBookingSystem SBS = new SeatBookingSystem(10);
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\t ~~ Welcome to Train Seat Booking System ~~");
        while (true) {
            System.out.println("\n 1) Book a seat");
            System.out.println(" 2) Cancel a booking");
            System.out.println(" 3) View available seats");
            System.out.println(" 4) Exit");
            System.out.print("Select an option (1, 2, 3, or 4): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = sc.nextLine().trim();
                    System.out.print("Enter a seat number (between 0 and 9): ");
                    int seatNumber = sc.nextInt();
                    sc.nextLine();
                    SBS.bookSeat(seatNumber, passengerName);
                    break;
                case 2:
                    System.out.print("Enter seat number to cancel booking: ");
                    int cancelSeatNumber = sc.nextInt();
                    sc.nextLine();
                    break;
                case 3:
                    SBS.searchAvailableSeats();
                    break;
                case 4:
                    System.out.println("\t ~~ Thanks for using train seat booking system ~~");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}