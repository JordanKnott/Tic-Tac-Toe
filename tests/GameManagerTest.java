import core.Board;
import core.GameManager;
import core.Piece;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class GameManagerTest {

    @Test
    public void testGameManagerState(){
        GameManager gameManager = new GameManager();
        gameManager.setPlayersTurn(1);
        gameManager.setPiece(0,0);
        gameManager.setPiece(0, 1);
        assertTrue(gameManager.getBoard().getPiece(0, 1).getOwner() == 2);
    }

    @Test
    public void testDummyGame(){
        GameManager gameManager = new GameManager();
        gameManager.setPlayersTurn(Piece.X);
        gameManager.setPiece(0, 0);
        gameManager.setPiece(0, 1);

        gameManager.setPiece(1, 0);
        gameManager.setPiece(1, 1);

        gameManager.setPiece(2, 0);
        assertTrue(gameManager.hasPlayerWon() == Piece.X);
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
}
