package LLD.Bank;

import java.util.Random;
public class CheckingAccount extends Account{

    public CheckingAccount(){
        super();
    }

    @Override
    public boolean deposit(long amount) {
        return false;
    }

    @Override
    public boolean withdraw(long amount) {
        return false;
    }

}
