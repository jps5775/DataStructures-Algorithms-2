package LLD.DeckOfCards;

import java.util.List;

public class Deck {
    private Card[] deck;

    public Deck(){
        this.deck = randomDeck();
    }

    private Card[] randomDeck(){
        return new Card[52];
    }

    public List<Card> dealHand(){
        return null;
    }

    public Card dealCard(){
        return null;
    }

    public void shuffle(){

    }

}
