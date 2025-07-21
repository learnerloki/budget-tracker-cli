public class ChoiceValidator {

    public int getValidChoice(String input) {
        try {
            int choice = Integer.parseInt(input);
            if (choice < 1 || choice > 5) {
                throw new IllegalArgumentException("Choice must be between 1 and 5.");
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
