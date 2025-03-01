package LLD.ConnectN;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Grid grid;
    private int targetScore;
    private Map<Player, Integer> totalScores;

    public Game(int n, int m, int targetScore){
        this.grid = new Grid(n, m);
        this.targetScore = targetScore;
        this.totalScores = new HashMap<>(){{
            put(Player.RED, 0);
            put(Player.YELLOW, 0);
        }};
    }

    public void printBoard(){
        // TODO: prints board
    }

    public void play(){
        // TODO: call playRound() in a loop and update the scores after each round
        // TODO: until a player reaches the targetScore

    }

    private Player playRound(){
        // TODO: loop between each players and ask them to playMove()
        // TODO: and after placing a piece check if they won and return that player
        return null;
    }

    private void playMove(Player player) {
        int numOfCols = this.grid.getColumnCount();
        // TODO: ask for col from 0 - numOfCols from user input
        int moveCol = 0; // comes from user input
        this.grid.placePiece(moveCol, player);
    }

}
