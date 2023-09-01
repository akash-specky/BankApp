package Accounts;

import Transactions.Transaction;
import Utility.RandomStringGenerator;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountExceptions;
import exceptions.UnauthorizedActionException;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount implements Account {
    private String accountNumber;
    private String name;
    private boolean isAccountClosed;
    private double balance;
    private List<Transaction> transactionHistory;

    public SavingsAccount(String name,boolean isAccountClosed) {
        this.accountNumber = RandomStringGenerator.generateRandomString(4);
        this.name = name;
        this.balance = 0;
        this.isAccountClosed=isAccountClosed;
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
    public void deposit(double amount) throws InvalidAmountExceptions {
        if (amount <= 0) {
            throw new InvalidAmountExceptions("Invalid deposit amount: " + amount);
        }
        balance += amount;
        System.out.println("Dear " + name + ", deposited: " + amount + ". The current balance is " + getBalance() + ".");
        addTransaction(new Transaction("Deposit", amount));
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountExceptions, InsufficientFundsException, UnauthorizedActionException {
        if (amount <= 0) {
            throw new InvalidAmountExceptions("Invalid withdrawal amount: " + amount);
        }
        if (isAccountClosed) {
            throw new UnauthorizedActionException("Accounts.Account is closed. Withdrawal not allowed.");
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Dear " + name + ", withdrawn: " + amount + ". The current balance is " + getBalance() + ".");
            addTransaction(new Transaction("Withdrawal", amount));
        } else {
            throw new InsufficientFundsException("Insufficient balance for withdrawal.");
        }
    }

    @Override
    public void transfer(Account destinationAccount, double amount) throws InvalidAmountExceptions, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountExceptions("Invalid transfer amount: " + amount);
        }

        if (balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            System.out.println("Dear " + name + ", transferred: " + amount + " to account " + destinationAccount.getAccountNumber() + ".");
            addTransaction(new Transaction("Transfer to " + destinationAccount.getAccountNumber(), amount));
            destinationAccount.addTransaction(new Transaction("Transfer from " + getAccountNumber(), amount));
        } else {
            throw new InsufficientFundsException("Insufficient balance for transfer.");
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    @Override
    public void displayStatement() {
        System.out.println("Accounts.Account Statement for Saving Accounts.Account " + getAccountNumber());
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getDescription() + ": " + transaction.getAmount());
        }
        System.out.println("Current Balance: " + getBalance());
    }

    @Override
    public boolean isAccountClosed() {
        return false;
    }

}
