package net.thenightwolf.tictactoe.core;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class Board {

    private Piece[][] board = new Piece[3][3];

    public Board(){
        resetBoard();
    }

    public boolean isEmpty() {
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                if(board[x][y] == null)
                    return false;
            }
        }
        return true;
    }

    public boolean isFull(){
        int counter = 0;
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                if(board[x][y].getOwner() != Piece.EMPTY)
                    counter++;
            }
        }
        if(counter == 9)
            return true;
        return false;
    }

    public boolean setPiece(int x, int y, Piece piece){
        if(board[x][y].getOwner() != Piece.EMPTY){
            return false;
        }
        board[x][y] = piece;
        return true;
    }

    public Piece getPiece(int x, int y){
        return board[x][y];
    }

    public void resetBoard(){
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                board[x][y] = new Piece();
            }
        }
    }


}
