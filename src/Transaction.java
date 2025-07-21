import java.time.LocalDate;

public class Transaction {
    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public Transaction(double amount, String description, LocalDate date, TransactionType type) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.type = type;
    }
    @Override
    public String toString() {
        return "[" + type + "] ₹" + amount + " - " + description + " on " + date;
    }

    private double amount;
    private String description;
    private LocalDate date;
    private TransactionType type;
}
