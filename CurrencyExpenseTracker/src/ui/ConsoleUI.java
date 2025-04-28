package ui;
import java.util.Scanner;
import service.CurrencyConverter;
import dao.ExpenseDAOImpl;
import model.Expense;
import java.util.List;
public class ConsoleUI {
    private Scanner scanner = new Scanner(System.in);
    private ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl();
    public void start() {
        while (true) {
            System.out.println("=== Currency & Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. Edit Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Currency Converter");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) addExpense();
            else if (choice == 2) editExpense();
            else if (choice == 3) deleteExpense();
            else if (choice == 4) viewExpenses();
            else if (choice == 5) currencyConvert();
            else if (choice == 6) break;
            else System.out.println("Invalid option.");
        }
    }
    private void addExpense() {
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Currency: ");
        String currency = scanner.nextLine();
        System.out.print("Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        Expense expense = new Expense(0, amount, category, currency, date, description);
        expenseDAO.addExpense(expense);
        System.out.println("Expense added.");
    }
    private void editExpense() {
        System.out.print("Enter Expense ID to Edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        Expense old = expenseDAO.getExpenseById(id);
        if (old == null) {
            System.out.println("Expense not found.");
            return;
        }
        System.out.print("New Amount (" + old.getAmount() + "): ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("New Category (" + old.getCategory() + "): ");
        String category = scanner.nextLine();
        System.out.print("New Currency (" + old.getCurrency() + "): ");
        String currency = scanner.nextLine();
        System.out.print("New Date (" + old.getDate() + "): ");
        String date = scanner.nextLine();
        System.out.print("New Description (" + old.getDescription() + "): ");
        String description = scanner.nextLine();
        Expense updated = new Expense(id, amount, category, currency, date, description);
        expenseDAO.updateExpense(updated);
        System.out.println("Expense updated.");
    }
    private void deleteExpense() {
        System.out.print("Enter Expense ID to Delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        expenseDAO.deleteExpense(id);
        System.out.println("Expense deleted.");
    }
    private void viewExpenses() {
        List<Expense> expenses = expenseDAO.getAllExpenses();
        for (Expense e : expenses) {
            System.out.println(e.getId() + " | " + e.getAmount() + " " + e.getCurrency() + " | " + e.getCategory() + " | " + e.getDate() + " | " + e.getDescription());
        }
    }
    private void currencyConvert() {
        System.out.print("From Currency: ");
        String from = scanner.nextLine();
        System.out.print("To Currency: ");
        String to = scanner.nextLine();
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        double result = CurrencyConverter.convert(from, to, amount);
        System.out.println("Converted Amount: " + result + " " + to);
    }
}