import java.util.LinkedList;
import java.util.Scanner;

class StockManagementSystem {
    LinkedList<Double> stockPricesList;

    public StockManagementSystem() {
        stockPricesList = new LinkedList<>();
    }

    public void addPrice(double stockPrice) { // time complexity - O(1) amortised
        stockPricesList.add(stockPrice);
        System.out.println("Stock price added in the list Successfully!");
    }

    public void removeOutdatedPrice() { // time complexity - O(1) as NO shifting required!
        if (stockPricesList.isEmpty()) {
            System.out.println("Error: No stock prices in the list!");
        } else {
            stockPricesList.removeFirst();
            System.out.println("Outdated price removed Successfully!");
        }
    }

    public double getHighestPrice() { // time complexity - O(n) as traversing required
        if (stockPricesList.isEmpty()) {
            return -1;
        } else {
            double temp = 0;
            for (double i : stockPricesList) {
                if (i > temp) {
                    temp = i;
                }
            }
            return temp;
        }
    }

    public double getMinimumPrice() { // time complexity - O(n) as traversing required
        if (stockPricesList.isEmpty()) {
            return -1;
        } else {
            double temp = stockPricesList.getFirst();
            for (double i : stockPricesList) {
                if (i < temp) {
                    temp = i;
                }
            }
            return temp;
        }
    }
}

public class Scenario2WithLinkedList {
    public static void main(String[] args) {
        StockManagementSystem SMS = new StockManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\t ~~ Welcome to Stock Market Application ~~");
        while (true) {
            System.out.println("\n 1) Add stock price");
            System.out.println(" 2) Remove Outdated stock price");
            System.out.println(" 3) Get Maximum stock price");
            System.out.println(" 4) Get Minimum stock price");
            System.out.println(" 5) Exit");
            System.out.print("Select an option (1,2,3,4 or 5): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter stock price: ");
                    double price = sc.nextDouble();
                    SMS.addPrice(price);
                    break;
                case 2:
                    SMS.removeOutdatedPrice();
                    break;
                case 3:
                    if (SMS.getHighestPrice() == -1) {
                        System.out.println("Error: No stock prices in the list!");
                    } else {
                        System.out.println("Highest stock price: " + SMS.getHighestPrice());
                    }
                    break;
                case 4:
                    if (SMS.getMinimumPrice() == -1) {
                        System.out.println("Error: No stock prices in the list!");
                    } else {
                        System.out.println("Minimum stock price: " + SMS.getMinimumPrice());
                    }
                    break;
                case 5:
                    System.out.println("\t ~~ Thanks for using Stock Market Application(SMS)");
                    return;
            }
        }
    }
}