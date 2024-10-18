import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private Map<String, Double> expenses;

    // Constructor to initialize the expenses map
    public ExpenseTracker() {
        expenses = new HashMap<>();
    }

    // Method to add an expense to a specific category
    public void addExpense(String category, double amount) {
        // If the category already exists, add the amount to the existing value
        // Otherwise, create a new entry with the given amount
        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
    }

    // Method to view all expenses by category
    public void viewExpenses() {
        System.out.println("Expenses:");
        // Iterate through the map and print each category and its total expense
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to calculate and return the total expenses
    public double getTotalExpenses() {
        double total = 0.0;
        // Sum up all the values in the expenses map
        for (double amount : expenses.values()) {
            total += amount;
        }
        return total;
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main loop to display the menu and handle user input
        do {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle the user's menu choice
            switch (choice) {
                case 1:
                    // Add an expense
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(category, amount);
                    System.out.println("Expense added.");
                    break;
                case 2:
                    // View all expenses
                    tracker.viewExpenses();
                    break;
                case 3:
                    // View total expenses
                    System.out.println("Total Expenses: $" + tracker.getTotalExpenses());
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4); // Continue until the user chooses to exit

        scanner.close(); // Close the scanner to free up resources
    }
}