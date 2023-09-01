import java.util.ArrayList;
import java.util.List;

public class JointAccount implements Account {
    private String accountNumber;

    private String name;
    private double balance;
    private List<Transaction> transactionHistory;

    public JointAccount(String accountNumber,String name) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.name = name;
        this.transactionHistory = new ArrayList<>();
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". Current Balance is " + getBalance());
        addTransaction(new Transaction("Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Current Balance is " + getBalance());
            addTransaction(new Transaction("Withdrawal", -amount));
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    @Override
    public void transfer(Account destinationAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Transferred: " + amount + " to account " + destinationAccount.getAccountNumber());
            addTransaction(new Transaction("Transfer to " + destinationAccount.getAccountNumber(), -amount));
            destinationAccount.addTransaction(new Transaction("Transfer from " + getAccountNumber(), amount));
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    @Override
    public void displayStatement() {
        System.out.println("Account Statement for Account " + getAccountNumber());
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getDescription() + ": " + transaction.getAmount());
        }
        System.out.println("Current Balance: " + getBalance());
    }
}
