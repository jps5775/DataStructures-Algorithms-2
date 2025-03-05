package LLD.Bank;

import java.util.Random;

public class Client {
    private String name;
    private int cashAmount;
    private long clientId;

    public Client(String name, int cashAmount){
        this.name = name;
        this.cashAmount = cashAmount;
        this.clientId = new Random().nextLong();
    }
}
