package LLD.ATM;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(int accountNumber, int balance){
        super(accountNumber, balance);
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        this.balance -= amount;
    }
}
