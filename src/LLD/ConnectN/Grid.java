package LLD.ConnectN;

public class Grid {
    private int[][] grid;
    private int n;
    private int m;

    public Grid(int n, int m){
        this.n = n;
        this.m = m;
        this.grid = new int[n][m];
    }

    public void placePiece(int col, Player player){
        // TODO: places piece in the col for the player
    }

    public boolean checkWon(){
        // TODO: checks the Board for any connected N in any 8 directions
        return false;
    }

    public int[][] getGrid(){
        return this.grid;
    }

    public int getColumnCount(){
        return m;
    }
}
