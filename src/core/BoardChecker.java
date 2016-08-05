package core;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class BoardChecker {

    public static boolean checkBoard(Board board, int x){
        boolean resultOne = checkTopDown(board, x);
        boolean resultTwo = checkLeftRight(board, x);
        boolean resultThree = checkDiagnals(board, x);
        if(resultOne || resultTwo || resultThree){
            return true;
        }
        return false;
    }

    private static boolean checkTopDown(Board board, int x) {
        if (board.getPiece(0, 0).getOwner() == x && board.getPiece(1, 0).getOwner() == x && board.getPiece(2, 0).getOwner() == x) {
            return true;
        } else if (board.getPiece(0, 1).getOwner() == x && board.getPiece(1, 1).getOwner() == x && board.getPiece(2, 1).getOwner() == x) {
            return true;
        } else if (board.getPiece(0, 2).getOwner() == x && board.getPiece(1, 2).getOwner() == x && board.getPiece(2, 2).getOwner() == x) {
            return true;
        }
        return false;
    }

    private static boolean checkLeftRight(Board board, int x){
        if(board.getPiece(0,0).getOwner() == x && board.getPiece(0, 1).getOwner() == x && board.getPiece(0, 2).getOwner() == x){
            return true;
        } else if(board.getPiece(1,0).getOwner() == x && board.getPiece(1, 1).getOwner() == x && board.getPiece(1, 2).getOwner() == x){
            return true;
        } else if(board.getPiece(2,0).getOwner() == x && board.getPiece(2, 1).getOwner() == x && board.getPiece(2, 2).getOwner() == x){
            return true;
        }
        return false;
    }

    private static boolean checkDiagnals(Board board, int x){
        if(board.getPiece(0,0).getOwner() == x && board.getPiece(1,1).getOwner() == x && board.getPiece(2,2).getOwner() == x){
            return true;
        } else if(board.getPiece(2,0).getOwner() == x && board.getPiece(1,1).getOwner() == x && board.getPiece(0,2).getOwner() == x){
            return true;
        }
        return false;
    }


}
