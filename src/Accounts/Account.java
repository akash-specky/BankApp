package Accounts;

import Transactions.Transaction;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountExceptions;
import exceptions.UnauthorizedActionException;

public interface Account {

    String getAccountNumber();

    String getAccountName();

    double getBalance();

    void deposit(double amount) throws InvalidAmountExceptions;

    void withdraw(double amount) throws InvalidAmountExceptions, InsufficientFundsException, UnauthorizedActionException;

    void transfer(Account destinationAccount, double amount) throws InvalidAmountExceptions, InsufficientFundsException;

    void addTransaction(Transaction transaction);


    void displayStatement();

    boolean isAccountClosed();

}
