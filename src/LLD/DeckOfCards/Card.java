package LLD.DeckOfCards;

public class Card {
    private Suit suit;
    private int value;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue(){
        return value;
    }
}
