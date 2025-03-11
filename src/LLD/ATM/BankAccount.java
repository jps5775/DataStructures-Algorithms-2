package LLD.ATM;

public abstract class BankAccount {
    protected int accountNumber;
    protected int balance;

    public BankAccount(int accountNumber, int balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(int amount);
    public abstract void withdraw(int amount);
}
