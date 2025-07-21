import java.util.Scanner;

public class BudgetApp {
    private final Scanner scanner;
    private final BudgetManager manager;
    private final TransactionHandler transactionHandler;
    private final ChoiceValidator choiceValidator;
    private boolean running;

    public BudgetApp() {
        scanner = new Scanner(System.in);
        manager = new BudgetManager();
        transactionHandler = new TransactionHandler(scanner, manager);
        choiceValidator = new ChoiceValidator();
        running = true;
    }

    public void run() {
        while (running) {
            showMenu();
            String input = scanner.nextLine();
            int choice = choiceValidator.getValidChoice(input);
            handleChoice(choice);
        }

        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n====== Personal Budget Tracker ======");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Transactions");
        System.out.println("4. View Balance");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1 -> transactionHandler.addTransaction(TransactionType.INCOME);
            case 2 -> transactionHandler.addTransaction(TransactionType.EXPENSE);
            case 3 -> manager.viewTransactions();
            case 4 -> System.out.printf("Your current balance is: ₹%.2f%n", manager.getBalance());
            case 5 -> {
                System.out.println("Exiting... Goodbye!");
                running = false;
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

    public BudgetManager getManager() {
        return manager;
    }
}
