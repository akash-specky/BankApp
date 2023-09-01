package Banks;

import Accounts.Account;
import exceptions.*;

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

    public Account getAccountByNumber(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Accounts.Account with number " + accountNumber + " not found.");
    }


    public void transfer(Account sourceAccount, Account destinationAccount, double amount) throws InvalidAmountExceptions, InsufficientFundsException {
        if (sourceAccount != null && destinationAccount != null) {
            sourceAccount.transfer(destinationAccount, amount);
        } else {
            System.out.println("Invalid source or destination account.");
        }
    }


    public void transferToExternalBank(Account sourceAccount, String destinationBank, String destinationAccountNumber, double amount) throws ExternalBankTransferException, UnauthorizedActionException, InvalidAmountExceptions {
        if (sourceAccount == null || sourceAccount.isAccountClosed()) {
            throw new UnauthorizedActionException("Source account is invalid or closed.");
        }
        Bank destinationBankInstance = BankList.getBankByName(destinationBank);
        if (destinationBankInstance == null) {
            throw new ExternalBankTransferException("Destination bank not found.");
        }
        Account destinationAccount;
        try {
            destinationAccount = destinationBankInstance.getAccountByNumber(destinationAccountNumber);
        } catch (AccountNotFoundException e) {
            throw new ExternalBankTransferException("Destination account not found in the destination bank.");
        }
        try {
            sourceAccount.transfer(destinationAccount, amount);
        } catch (InsufficientFundsException e) {
            throw new ExternalBankTransferException("Insufficient funds for external bank transfer.");
        } catch (InvalidAmountExceptions e) {
            throw new InvalidAmountExceptions("Invalid Amount");
        }

    }
}
