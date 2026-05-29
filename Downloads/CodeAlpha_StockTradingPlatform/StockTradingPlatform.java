import java.util.ArrayList;
import java.util.Scanner;

class Stock {

    String stockName;
    double price;
    int quantity;

    Stock(String stockName, double price, int quantity) {

        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
    }
}

public class StockTradingPlatform {

    static ArrayList<Stock> portfolio = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static double balance = 10000;

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     STOCK TRADING PLATFORM");
            System.out.println("=================================");

            System.out.println("1. View Balance");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewBalance();
                    break;

                case 2:
                    buyStock();
                    break;

                case 3:
                    sellStock();
                    break;

                case 4:
                    viewPortfolio();
                    break;

                case 5:
                    System.out.println("Thank you for using the platform!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void viewBalance() {

        System.out.println("\nCurrent Balance: $" + balance);
    }

    static void buyStock() {

        System.out.print("Enter stock name: ");
        String name = sc.nextLine();

        System.out.print("Enter stock price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        double totalCost = price * quantity;

        if (totalCost <= balance) {

            balance -= totalCost;

            portfolio.add(new Stock(name, price, quantity));

            System.out.println("Stock purchased successfully!");

        } else {

            System.out.println("Insufficient balance!");
        }
    }

    static void sellStock() {

        System.out.print("Enter stock name to sell: ");
        String name = sc.nextLine();

        for (Stock s : portfolio) {

            if (s.stockName.equalsIgnoreCase(name)) {

                double amount = s.price * s.quantity;

                balance += amount;

                portfolio.remove(s);

                System.out.println("Stock sold successfully!");

                return;
            }
        }

        System.out.println("Stock not found in portfolio!");
    }

    static void viewPortfolio() {

        System.out.println("\n========== PORTFOLIO ==========");

        if (portfolio.isEmpty()) {

            System.out.println("No stocks purchased.");

        } else {

            for (Stock s : portfolio) {

                System.out.println(
                    "Stock: " + s.stockName +
                    " | Price: $" + s.price +
                    " | Quantity: " + s.quantity
                );
            }
        }
    }
}