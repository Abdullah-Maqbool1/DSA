import java.util.ArrayList;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> reservedSeatsNumbersList = new ArrayList<>();
        System.out.println("~~~~~ Ticket Booking System ~~~~~");
        int seatNumber;
        int choice;
        while (true) {
            System.out.println(" 1) Reserve a Seat");
            System.out.println(" 2) Remove a reserved Seat");
            System.out.println(" 3) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a Seat Number to reserve: ");
                    seatNumber = sc.nextInt();
                    if (!reservedSeatsNumbersList.contains(seatNumber)) {
                        reservedSeatsNumbersList.add(seatNumber);
                        System.out.println("Seat reserved successfully!");
                    } else
                        System.out.println("Error: SeatNumber # " + seatNumber + ", is already reserved!");
                    break;
                case 2:
                    System.out.println("Enter a Seat Number to remove from reservations: ");
                    seatNumber = sc.nextInt();
                    if (reservedSeatsNumbersList.contains(seatNumber)) {
                        for (int i = 0; i < reservedSeatsNumbersList.size(); i++) {
                            if (reservedSeatsNumbersList.get(i) == seatNumber) {
                                reservedSeatsNumbersList.remove(i);
                                System.out.println("Seat removed from reservations successfully!");
                                break;
                            }
                        }
                    } else
                        System.out.println("Error: SeatNumber # " + seatNumber + ", is never reserved!");
                    break;
                case 3:
                    System.out.println("Thanks from visiting, BYE");
                    sc.close();
                    return;
                default:
                    System.out.println("Error: Invalid Input");
            }
        }
    }
}