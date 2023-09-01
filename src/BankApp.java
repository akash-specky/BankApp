public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        SavingsAccount savingsAccount = new SavingsAccount("SA123","Akash");
        CheckingAccount checkingAccount = new CheckingAccount("CA456","Ankit");
        JointAccount jointAccount = new JointAccount("JA789","Neeraj");

        bank.addAccount(savingsAccount);
//        bank.addAccount(checkingAccount);
//        bank.addAccount(jointAccount);


        savingsAccount.deposit(1000);
//        checkingAccount.deposit(2000);
//        jointAccount.deposit(3000);

        savingsAccount.withdraw(500);
//        checkingAccount.transfer(savingsAccount, 1000);
//        jointAccount.transfer(savingsAccount, 1500);

        savingsAccount.displayStatement();
//        checkingAccount.displayStatement();
//        jointAccount.displayStatement();
    }
}
