public interface Account {

    String getAccountNumber();

    String getAccountName();

    double getBalance();

    void deposit(double amount);

    void withdraw(double amount);

    void transfer(Account destinationAccount, double amount);

    void addTransaction(Transaction transaction);

    void displayStatement();
}
