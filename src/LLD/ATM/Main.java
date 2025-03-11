package LLD.ATM;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount checking = new CheckingAccount(1, 0);
        BankAccount savings = new SavingsAccount(2, 0, .05);
        User user1 = new User(1,"Joe");

        ATM atm = new ATM();
        atm.addBankAccount(user1, checking);
        atm.addBankAccount(user1, savings);
        atm.depositTo(user1, checking.accountNumber, 100);
        atm.depositTo(user1, savings.accountNumber, 500);

        List<BankAccount> myAccounts = atm.getBankAccounts(user1);
        for(int i = 0 ; i < myAccounts.size(); i++) {
            System.out.println(myAccounts.get(i).balance);
        }

        ((SavingsAccount) savings).addInterest();

        for(int i = 0 ; i < myAccounts.size(); i++) {
            System.out.println(myAccounts.get(i).balance);
        }
    }
}
