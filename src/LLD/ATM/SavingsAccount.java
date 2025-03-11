package LLD.ATM;

public class SavingsAccount extends BankAccount{

    private final double interestRate;

    public SavingsAccount(int accountNumber, int balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void addInterest(){
        double interestToAdd = interestRate * balance;
        balance += (int) interestToAdd;
    }
}
