
import java.util.*;

public class ExpenseManager {
    private Map<String, User> users;
    public ExpenseManager() {
        users = new HashMap<>();
    }
    public void addUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
        }
    }
    public void addExpense(String name, double amount) {
        if (users.containsKey(name)) {
            users.get(name).addPayment(amount);
        }
    }
    public void showBalances() {
        double total = 0.0;
        for (User user : users.values()) {
            total += user.getTotalPaid();
        }
        int userCount = users.size();
        if (userCount == 0) return;
        double share = total / userCount;
        for (User user : users.values()) {
            double balance = user.getTotalPaid() - share;
            System.out.println(user.getName() + " balance: " + balance);
        }
    }
}

import java.util.*;

public class ExpenseManager {
    private Map<String, User> users;
    public ExpenseManager() {
        users = new HashMap<>();
    }
    public void addUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
        }
    }
    public void addExpense(String name, double amount) {
        if (users.containsKey(name)) {
            users.get(name).addPayment(amount);
        }
    }
    public void showBalances() {
        double total = 0.0;
        for (User user : users.values()) {
            total += user.getTotalPaid();
        }
        int userCount = users.size();
        if (userCount == 0) return;
        double share = total / userCount;
        for (User user : users.values()) {
            double balance = user.getTotalPaid() - share;
            System.out.println(user.getName() + " balance: " + balance);
        }
    }
}

import java.util.*;

public class ExpenseManager {
    private Map<String, User> users;
    public ExpenseManager() {
        users = new HashMap<>();
    }
    public void addUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
        }
    }
    public void addExpense(String name, double amount) {
        if (users.containsKey(name)) {
            users.get(name).addPayment(amount);
        }
    }
    public void showBalances() {
        double total = 0.0;
        for (User user : users.values()) {
            total += user.getTotalPaid();
        }
        int userCount = users.size();
        if (userCount == 0) return;
        double share = total / userCount;
        for (User user : users.values()) {
            double balance = user.getTotalPaid() - share;
            System.out.println(user.getName() + " balance: " + balance);
        }
    }
}

import java.util.*;

public class ExpenseManager {
    private Map<String, User> users;
    public ExpenseManager() {
        users = new HashMap<>();
    }
    public void addUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
        }
    }
    public void addExpense(String name, double amount) {
        if (users.containsKey(name)) {
            users.get(name).addPayment(amount);
        }
    }
    public void showBalances() {
        double total = 0.0;
        for (User user : users.values()) {
            total += user.getTotalPaid();
        }
        int userCount = users.size();
        if (userCount == 0) return;
        double share = total / userCount;
        for (User user : users.values()) {
            double balance = user.getTotalPaid() - share;
            System.out.println(user.getName() + " balance: " + balance);
        }
    }
}

import java.util.*;

public class ExpenseManager {
    private Map<String, User> users;
    public ExpenseManager() {
        users = new HashMap<>();
    }
    public void addUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
        }
    }
    public void addExpense(String name, double amount) {
        if (users.containsKey(name)) {
            users.get(name).addPayment(amount);
        }
    }
    public void showBalances() {
        double total = 0.0;
        for (User user : users.values()) {
            total += user.getTotalPaid();
        }
        int userCount = users.size();
        if (userCount == 0) return;
        double share = total / userCount;
        for (User user : users.values()) {
            double balance = user.getTotalPaid() - share;
            System.out.println(user.getName() + " balance: " + balance);
        }
    }
}
