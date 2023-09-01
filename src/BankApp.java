import Accounts.CheckingAccount;
import Accounts.JointAccount;
import Accounts.SavingsAccount;
import Banks.Bank;
import Banks.BankList;
import exceptions.*;

public class BankApp {
    public static void main(String[] args) throws InvalidAmountExceptions, InsufficientFundsException, UnauthorizedActionException, AccountNotFoundException, ExternalBankTransferException {

        Bank bank = new Bank();
        Bank bank2 = new Bank();
        BankList.addBank(bank);
        BankList.addBank(bank2);

        SavingsAccount savingsAccount = new SavingsAccount("Akash",false);
        SavingsAccount savingsAccount2 = new SavingsAccount("Akshay",false);
        CheckingAccount checkingAccount = new CheckingAccount("Ankit",false);
        JointAccount jointAccount = new JointAccount("Neeraj",false);

        bank.addAccount(savingsAccount);
        bank2.addAccount(savingsAccount2);
        //        bank.addAccount(checkingAccount);
//        bank.addAccount(jointAccount);


        savingsAccount.deposit(1000);
//        checkingAccount.deposit(2000);
//        jointAccount.deposit(3000);

//        try {
//            bank.transferToExternalBank(savingsAccount, savingsAccount2.getAccountNumber(), "5678", 100.0);
//        } catch (ExternalBankTransferException e) {
//            throw new ExternalBankTransferException("Banks.Bank Not Found");
//        }


        savingsAccount.withdraw(500);
        savingsAccount.deposit(1345);
//        checkingAccount.transfer(savingsAccount, 1000);
//        jointAccount.transfer(savingsAccount, 1500);

        savingsAccount.displayStatement();
//        checkingAccount.displayStatement();
//        jointAccount.displayStatement();
    }
}
