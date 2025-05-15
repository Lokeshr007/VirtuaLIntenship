package src;

import java.util.*;

public class ExpenseManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Double> balanceSheet = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getName(), user);
        balanceSheet.put(user.getName(), 0.0);
    }

    public void addExpense(String payer, double amount, List<String> splitWith) {
        int totalPeople = splitWith.size();
        double share = amount / totalPeople;

        for (String user : splitWith) {
            if (!user.equals(payer)) {
                balanceSheet.put(user, balanceSheet.getOrDefault(user, 0.0) - share);
                balanceSheet.put(payer, balanceSheet.getOrDefault(payer, 0.0) + share);
            }
        }
    }

    public void showBalances() {
        System.out.println("\nFinal Balances:");
        for (Map.Entry<String, Double> entry : balanceSheet.entrySet()) {
            String name = entry.getKey();
            double balance = entry.getValue();
            if (balance > 0) {
                System.out.println(name + " should receive ₹" + String.format("%.2f", balance));
            } else if (balance < 0) {
                System.out.println(name + " should pay ₹" + String.format("%.2f", -balance));
            } else {
                System.out.println(name + " is settled up.");
            }
        }
    }
}