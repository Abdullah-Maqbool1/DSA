import java.util.Scanner;

class SeatBookingSystem {
    String[] seats;
    int totalSeats;

    public SeatBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new String[totalSeats];
    }

    public void bookSeat(int seatNumber, String passengerName) {  // time complexity - O(1)
        if (seatNumber >= 0 && seatNumber < totalSeats) {
            if(seats[seatNumber]==null) {
                seats[seatNumber] = passengerName;
                System.out.println("Seat number " + seatNumber + " booked successfully!");
            }
            else{
                System.out.println("Sorry, Seat is already booked!");
            }
        } else {
            System.out.println("Error: Invalid seat number.");
        }
    }

    public void cancelSeat(int seatNumber) { // time complexity - O(1)
        if (seatNumber >= 0 && seatNumber < totalSeats) {
            if(seats[seatNumber]!=null){
            seats[seatNumber] = null;
            System.out.println("Seat number " + seatNumber + " Canceled successfully!");
            }else{
                System.out.println("This seat is never booked before!");
            }
        } else {
            System.out.println("Error: Invalid seat number.");
        }
    }

    public void searchAvailableSeats() { // time complexity - O(n)
        System.out.print("Available seats are (seat number): ");
        boolean allSeatsBooked = true;
        for (int i = 0; i < totalSeats; i++) {
            if (seats[i] == null) {
                System.out.print(i + ",");
                allSeatsBooked = false;
            }
        }
        if (allSeatsBooked)
            System.out.println("No seats available!");
    }
}

public class Scenario3WithArray {
    public static void main(String[] args) {
        SeatBookingSystem SBS = new SeatBookingSystem(10);
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("\t ~~ Welcome to Train seat booking system ~~");
        while(true){
            System.out.println("\n 1) Book a seat");
            System.out.println(" 2) Cancel a booking");
            System.out.println(" 3) View available seats");
            System.out.println(" 4) Exit");
            System.out.print("Select an option(1,2,3 or 4): ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = sc.nextLine().trim();
                    sc.nextLine();
                    System.out.print("Enter a seat number (between 0 and 9): ");
                    int seatNumber = sc.nextInt();
                    SBS.bookSeat(seatNumber,passengerName);
                    break;
                case 2:
                    System.out.print("Enter seat number to cancel booking: ");
                    int cancelSeatNumber = sc.nextInt();
                    SBS.cancelSeat(cancelSeatNumber);
                    break;
                case 3:
                    SBS.searchAvailableSeats();
                    break;
                case 4:
                    System.out.println("\t ~~ Thanks for using train seat booking system ~~");
                    return;
            }
        }
    }
}
