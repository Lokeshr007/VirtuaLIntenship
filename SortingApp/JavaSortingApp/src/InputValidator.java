
public class InputValidator {
    public boolean isValidInput(String input) {
        return input.matches("^[0-9\s]+$");
    }
}
