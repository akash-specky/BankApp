package Banks;

import java.util.ArrayList;
import java.util.List;

public class BankList {
    private static List<Bank> banks = new ArrayList<>();

    public static void addBank(Bank bank) {
        banks.add(bank);
    }

    public static Bank getBankByName(String bankName) {
        for (Bank bank : banks) {
            // Assuming banks have unique names
            if (bank.getClass().getSimpleName().equals(bankName)) {
                return bank;
            }
        }
        return null; // Banks.Bank not found
    }
}