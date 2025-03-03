package LLD.DeckOfCards;

public class CardGame {
    private Deck deck;
    private Player[] players;
    private Player house;

    public CardGame(Player[] players){
        this.players = players;
    }

    private void play(){
        // Welcome to blackjack

        while(true){
            for(Player player : players){
                player.setHand(deck.dealHand());
            }

            house.setHand(deck.dealHand());

            // print players starting hands

            for (Player player : players) {
                playRound(player, house);
            }

            // ask player another round or not -> stop loop otherwise
        }

        // Thanks for playing
    }

    private void playRound(Player player, Player house){
        while(player.getScore() < 21 || house.getScore() < 21){

            // check if user wants to play
            boolean playerWantsToPlay = true;

            while(!player.getIsBusted()){
                // ask player if he wants a card or to stay
                player.getHand().add(deck.dealCard());
                if(player.getScore() > 21) player.setIsBusted(true);
                if(player.getScore() == 21) break;
            }

            // player lost
            if(player.getIsBusted()){ return; }
            // player won
            if(player.getScore() == 21){ return; }

            // otherwise let house play
            while(!house.getIsBusted()){
                house.getHand().add(deck.dealCard());
                if(house.getScore() > 21) house.setIsBusted(true);
                if(house.getScore() == 21) break;
            }

            // did house lose, if so, player won
            if(house.getIsBusted()) return;
            // check if house won
            if(player.getScore() == 21){ return; }

            // check which player won
            if(player.getScore() > house.getScore()){
                // player won
            }else{
                // player lost
            }
        }
    }
}
