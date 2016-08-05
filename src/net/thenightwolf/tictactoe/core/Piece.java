package net.thenightwolf.tictactoe.core;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class Piece {
    private int owner = 0;

    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int O = 2;

    public void setOwner(int owner){
        this.owner = owner;
    }

    public int getOwner(){
        return owner;
    }

}
