import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private final List<Transaction> transactions;

    public BudgetManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        System.out.println("\n--- Transaction History ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.INCOME) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }
        return balance;
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
