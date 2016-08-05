import core.GameManager;
import core.Piece;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import themes.Theme;
import themes.darktheme.DarkTheme;
import themes.magical.MagicalTheme;
import themes.runic.RunicTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class TicTacToe extends Application {

    private GameManager gameManager = new GameManager();

    private Theme currentTheme = new RunicTheme();

    private boolean hasWon = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        gameManager.setPlayersTurn(Piece.X);


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(new Font(20));

        new AnimationTimer(){

            @Override
            public void handle(long now) {
                gc.setFill(currentTheme.getBackgroundColor());
                gc.clearRect(0, 0, 500, 500);
                gc.fillRect(0, 0, 500, 500);
                gc.setEffect(new DropShadow(10, currentTheme.getBoardGlow()));
                gc.drawImage(currentTheme.getBackgroundImage(), 0, 0, 500, 500);
                gc.drawImage(currentTheme.getBoardImage(), 50, 50, 400, 400);

                drawBoard(gc);

                gc.setEffect(new DropShadow(10, currentTheme.getTextGlow()));
                gc.setFill(currentTheme.getTextColor());
                gc.setTextAlign(TextAlignment.LEFT);
                gc.fillText("Turn: " + ( gameManager.getPlayersTurn() == 1 ? 'X' : 'O' ), 10, 490);

                int winner = gameManager.hasPlayerWon();
                if(winner != Piece.EMPTY || gameManager.getBoard().isFull()){
                    hasWon = true;
                }
                if(hasWon) {
                    gc.setTextAlign(TextAlignment.CENTER);
                    gc.setEffect(new DropShadow(10, currentTheme.getTextGlow()));
                    if(winner == 0)
                        gc.fillText("CAT has WON!", 500 / 2, 500 / 2);
                    else
                        gc.fillText("PLAYER " + (winner == 1 ? 'X' : 'O') + " has WON!", 500 / 2, 500 / 2);
                }

            }
        }.start();



        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 500, 500);
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handleInput(event.getX(), event.getY());
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("Reseting board! " + hasWon + " : " + (event.getCode() == KeyCode.ENTER));
                if(hasWon && event.getCode() == KeyCode.ENTER){
                    hasWon = false;
                    gameManager.getBoard().resetBoard();
                    gameManager.setPlayersTurn(Piece.X);
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("logo.png"));
        primaryStage.setTitle("Tic Tac Toe - " + currentTheme.getThemeName());
        primaryStage.show();

    }

    public static void main(String... args){
        launch(args);
    }

    private void drawBoard(GraphicsContext gc){
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                drawCell(gc, x, y);
            }
        }
    }

    private void drawCell(GraphicsContext gc, int x, int y){
        if(gameManager.getBoard().getPiece(x,y).getOwner() == Piece.X){
            gc.setEffect(new DropShadow(10, currentTheme.getxGlow()));
            gc.drawImage(currentTheme.getX_texture(), 50 + (133 * x), 50 + (133 * y), 133, 133);
        } else if(gameManager.getBoard().getPiece(x,y).getOwner() == Piece.O){
            gc.setEffect(new DropShadow(10, currentTheme.getoGlow()));
            gc.drawImage(currentTheme.getO_texture(), 50 + (133 * x), 50 + (133 * y), 133, 133);
        }
    }

    private void handleInput(double mouseX, double mouseY){
        List<Rectangle> boundingBoxes = generateCollsionCells();
        int targetIndex = -1;
        for(Rectangle rectangle : boundingBoxes){
            if(rectangle.contains(mouseX, mouseY)){
                targetIndex = boundingBoxes.indexOf(rectangle);
            }
        }
        clickCell(targetIndex);
    }

    private List<Rectangle> generateCollsionCells(){
        List<Rectangle> rectangles = new ArrayList<Rectangle>();
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                rectangles.add(new Rectangle(50 + (133 * x), 50 + (133 * y), 133, 133));
            }
        }
        return rectangles;
    }

    private void clickCell(int targetIndex){
        switch(targetIndex){
            case 0:
                gameManager.setPiece(0,0);
                break;
            case 1:
                gameManager.setPiece(1,0);
                break;
            case 2:
                gameManager.setPiece(2,0);
                break;
            case 3:
                gameManager.setPiece(0,1);
                break;
            case 4:
                gameManager.setPiece(1,1);
                break;
            case 5:
                gameManager.setPiece(2,1);
                break;
            case 6:
                gameManager.setPiece(0,2);
                break;
            case 7:
                gameManager.setPiece(1,2);
                break;
            case 8:
                gameManager.setPiece(2,2);
                break;
            default:
        }
    }
}
