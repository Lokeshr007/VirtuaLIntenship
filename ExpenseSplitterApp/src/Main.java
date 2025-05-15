package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        System.out.println("Welcome to Expense Splitter App");
        System.out.print("Enter number of users: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter user name: ");
            String name = scanner.nextLine();
            manager.addUser(new User(name));
        }

        String choice;
        do {
            System.out.print("Enter payer name: ");
            String payer = scanner.nextLine();
            System.out.print("Enter amount paid: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter number of people to split with: ");
            int splitCount = scanner.nextInt();
            scanner.nextLine();

            List<String> splitWith = new ArrayList<>();
            for (int i = 0; i < splitCount; i++) {
                System.out.print("Enter name to split with: ");
                splitWith.add(scanner.nextLine());
            }

            manager.addExpense(payer, amount, splitWith);

            System.out.print("Add another expense? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        manager.showBalances();
    }
}