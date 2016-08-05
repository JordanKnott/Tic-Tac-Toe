package core;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class GameManager {
    private Board board;
    private int playersTurn = Piece.EMPTY;

    public GameManager(){
        board = new Board();
    }

    public Board getBoard(){
        return board;
    }

    public void setPiece(int x, int y){
        Piece piece = new Piece();
        piece.setOwner(playersTurn);
        if(!board.setPiece(x, y, piece)){
            return;
        }
        if(playersTurn == Piece.X)
            playersTurn = Piece.O;
        else if(playersTurn == Piece.O)
            playersTurn = Piece.X;
    }

    public void setPlayersTurn(int turn){
        playersTurn = turn;
    }

    public int hasPlayerWon(){
        if(BoardChecker.checkBoard(board, Piece.X))
            return Piece.X;
        if(BoardChecker.checkBoard(board, Piece.O))
            return Piece.O;
        return Piece.EMPTY;
    }

    public int getPlayersTurn(){
        return playersTurn;
    }
}
