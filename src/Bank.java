import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void transfer(Account sourceAccount, Account destinationAccount, double amount) {
        if (sourceAccount != null && destinationAccount != null) {
            sourceAccount.transfer(destinationAccount, amount);
        } else {
            System.out.println("Invalid source or destination account.");
        }
    }
}
