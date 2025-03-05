package LLD.Bank;

import java.util.Random;

public abstract class Account {

    protected long accountId;
    private long amount;

    public Account(){
        this.accountId = new Random().nextLong();
        this.amount = 0;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getAmount() {
        return amount;
    }

    abstract boolean deposit(long amount);
    abstract boolean withdraw(long amount);
}
