package Transactions;

public class Transaction {

    private final String description;
    private final double amount;

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}
