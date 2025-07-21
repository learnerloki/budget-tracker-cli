import java.time.LocalDate;
import java.util.Scanner;

public class TransactionHandler {
    private final Scanner scanner;
    private final BudgetManager manager;

    public TransactionHandler(Scanner scanner, BudgetManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void addTransaction(TransactionType type) {
        try {
            System.out.print("Enter amount: ₹");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            LocalDate date = LocalDate.now();

            Transaction transaction = new Transaction(amount, description, date, type);
            manager.addTransaction(transaction);

            System.out.println(type == TransactionType.INCOME ? "Income added!" : "Expense added!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
