
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        while (true) {
            System.out.println("1. Add User\n2. Add Expense\n3. Show Balances\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                manager.addUser(name);
            } else if (choice == 2) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                System.out.println("Enter amount spent:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                manager.addExpense(name, amount);
            } else if (choice == 3) {
                manager.showBalances();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        while (true) {
            System.out.println("1. Add User\n2. Add Expense\n3. Show Balances\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                manager.addUser(name);
            } else if (choice == 2) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                System.out.println("Enter amount spent:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                manager.addExpense(name, amount);
            } else if (choice == 3) {
                manager.showBalances();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        while (true) {
            System.out.println("1. Add User\n2. Add Expense\n3. Show Balances\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                manager.addUser(name);
            } else if (choice == 2) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                System.out.println("Enter amount spent:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                manager.addExpense(name, amount);
            } else if (choice == 3) {
                manager.showBalances();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        while (true) {
            System.out.println("1. Add User\n2. Add Expense\n3. Show Balances\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                manager.addUser(name);
            } else if (choice == 2) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                System.out.println("Enter amount spent:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                manager.addExpense(name, amount);
            } else if (choice == 3) {
                manager.showBalances();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        while (true) {
            System.out.println("1. Add User\n2. Add Expense\n3. Show Balances\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                manager.addUser(name);
            } else if (choice == 2) {
                System.out.println("Enter user name:");
                String name = scanner.nextLine();
                System.out.println("Enter amount spent:");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                manager.addExpense(name, amount);
            } else if (choice == 3) {
                manager.showBalances();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
