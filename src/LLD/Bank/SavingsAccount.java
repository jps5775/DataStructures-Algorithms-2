package LLD.Bank;

public class SavingsAccount extends Account{

    public SavingsAccount(){
        super();
    }

    @Override
    public boolean deposit(long amount){
        return true;
    }

    @Override
    public boolean withdraw(long amount){
        return true;
    }

}
