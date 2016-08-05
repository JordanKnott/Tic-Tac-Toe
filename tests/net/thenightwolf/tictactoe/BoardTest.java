package net.thenightwolf.tictactoe;

import net.thenightwolf.tictactoe.core.Board;
import net.thenightwolf.tictactoe.core.BoardChecker;
import net.thenightwolf.tictactoe.core.Piece;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class BoardTest {

    @Test
    public void testEmptyBoard(){
        Board board = new Board();
        assertTrue(board.isEmpty());
    }

    @Test
    public void testFullBoard(){
        Board board = new Board();
        Piece piece = new Piece();
        piece.setOwner(Piece.X);
        board.setPiece(0, 0, piece);
        board.setPiece(0, 1, piece);
        board.setPiece(0, 2, piece);

        board.setPiece(1, 0, piece);
        board.setPiece(1, 1, piece);
        board.setPiece(1, 2, piece);

        board.setPiece(2, 0, piece);
        board.setPiece(2, 1, piece);
        board.setPiece(2, 2, piece);
        assertTrue(board.isFull());
    }

    @Test
    public void testPiecePlacement(){
        Board board = new Board();
        Piece piece = new Piece();
        piece.setOwner(Piece.X);
        board.setPiece(1, 1, piece);
        int targetOwner = board.getPiece(1,1).getOwner();
        assertTrue(targetOwner == Piece.X);
    }

    private void printBoard(Board board){
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                int owner = board.getPiece(x,y).getOwner();
                if(owner == 0)
                    System.out.print(".");
                else if(owner == 1)
                    System.out.print("X");
                else if(owner == 2)
                    System.out.print("O");
            }
            System.out.println();
        }

    }

    @Test
    public void testWinCase(){
        Board board = new Board();
        Piece piece = new Piece();
        piece.setOwner(Piece.X);
        board.setPiece(0, 0, piece);
        board.setPiece(0, 1, piece);
        board.setPiece(0, 2, piece);
        assertTrue(BoardChecker.checkBoard(board, Piece.X));
    }

    @Test
    public void testBoardReset(){
        Board board = new Board();
        Piece piece = new Piece();
        piece.setOwner(Piece.X);
        board.setPiece(1, 1, piece);
        board.resetBoard();
        assertTrue(board.getPiece(1,1).getOwner() == Piece.EMPTY);
    }

}
