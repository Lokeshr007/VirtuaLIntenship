
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sorter sorter = new Sorter();
        InputValidator validator = new InputValidator();

        System.out.println("Enter numbers separated by space:");
        String input = sc.nextLine();

        if (!validator.isValidInput(input)) {
            System.out.println("Invalid input. Please enter only numbers.");
            return;
        }

        List<Integer> numbers = sorter.parseInput(input);
        System.out.println("Sort in (1) Ascending or (2) Descending?");
        int choice = sc.nextInt();

        if (choice == 1) {
            sorter.sortAscending(numbers);
        } else if (choice == 2) {
            sorter.sortDescending(numbers);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Sorted Numbers: " + numbers);
    }
}
