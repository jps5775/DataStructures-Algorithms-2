package LLD.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    Map<Client, List<Account>> allAccounts;

    public Bank(){
        allAccounts = new HashMap<>();
    }

    public long openNewAccount(AccountType type, Client client){
        Account newAccount = null;
        if(type == AccountType.SAVINGS_ACCOUNT){
            newAccount = new SavingsAccount();
        }else{
            newAccount = new CheckingAccount();
        }

        if(!allAccounts.containsKey(client)){
            allAccounts.put(client, new ArrayList<>());
        }
        allAccounts.get(client).add(newAccount);
        return newAccount.accountId;
    }

    public boolean deposit(long accountId, Client client, long amount){
        for(Account account : allAccounts.get(client)){
            if(account.getAccountId() == accountId){
                account.deposit(amount);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(long accountId, Client client, long amount){
        for(Account account : allAccounts.get(client)){
            if(account.getAccountId() == accountId){
                account.withdraw(amount);
                return true;
            }
        }
        return false;
    }
}
