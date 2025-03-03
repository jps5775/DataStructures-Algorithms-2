package LLD.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private List<Card> hand;
    private boolean isBusted;

    public Player(String name){
        this.name = name;
        this.score = 0;
        hand = new ArrayList<>();
        isBusted = false;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public boolean getIsBusted() {
        return isBusted;
    }

    public void setIsBusted(boolean isBusted) {
        this.isBusted = isBusted;
    }
}
