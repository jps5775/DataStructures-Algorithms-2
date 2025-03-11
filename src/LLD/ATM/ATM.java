package LLD.ATM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    private List<BankAccount> bankAccountList;
    private Map<User, List<BankAccount>> usersToBankAccountMap;

    public ATM(){
        this.bankAccountList = new ArrayList<>();
        this.usersToBankAccountMap = new HashMap<>();
    }

    public void addBankAccount(User user, BankAccount bankAccount){
        bankAccountList.add(bankAccount);
        if(!usersToBankAccountMap.containsKey(user)){
            usersToBankAccountMap.put(user, new ArrayList<>());
        }
        usersToBankAccountMap.get(user).add(bankAccount);
    }

    public void closeBankAccount(BankAccount bankAccount){
        bankAccountList.remove(bankAccount);
    }

    public List<BankAccount> getBankAccounts(User user){
        return usersToBankAccountMap.get(user);
    }

    public void depositTo(User user, long accountNumber, int amount){
        List<BankAccount> bankAccountsForUser = usersToBankAccountMap.get(user);
        for(BankAccount account : bankAccountsForUser){
            if(accountNumber == account.accountNumber){
                account.deposit(amount);
            }
        }
    }

    public void withdrawFrom(User user, long accountNumber, int amount){
        List<BankAccount> bankAccountsForUser = usersToBankAccountMap.get(user);
        for(BankAccount account : bankAccountsForUser){
            if(accountNumber == account.accountNumber){
                if(amount <= account.balance){
                    account.withdraw(amount);
                }
            }
        }
    }
}
