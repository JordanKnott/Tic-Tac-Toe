package net.thenightwolf.tictactoe;

import net.thenightwolf.tictactoe.core.GameManager;
import net.thenightwolf.tictactoe.core.Piece;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.thenightwolf.tictactoe.themes.Theme;
import net.thenightwolf.tictactoe.themes.darktheme.DarkTheme;
import net.thenightwolf.tictactoe.themes.magical.MagicalTheme;
import net.thenightwolf.tictactoe.themes.runic.RunicTheme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burni_000 on 8/4/2016.
 */
public class TicTacToe extends Application {

    private GameManager gameManager = new GameManager();

    private Theme currentTheme = new RunicTheme();

    private static int WIDTH = 1000;
    private static int HEIGHT = 800;
    private static int BOARD_SIZE = 600;
    private static int CELL_SIZE = BOARD_SIZE / 3;

    private boolean hasWon = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane menu = new GridPane();
        menu.setVgap(50);
        menu.setHgap(25);
        menu.setAlignment(Pos.CENTER);

        Label themeSelection = new Label("Theme");
        ComboBox<String> themeOptions = new ComboBox<>();
        themeOptions.getItems().addAll("Dark", "Mystic", "Runic");
        themeOptions.setValue("Runic");

        Label resSelection = new Label("Resolution");
        ComboBox<String> resOptions = new ComboBox<>();
        resOptions.getItems().addAll("1920x1080", "1600x900", "1280x720", "1024x768", "1000x800", "800x800", "500x500");
        resOptions.setValue("1000x800");

        Button play = new Button("Play");
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String theme = themeOptions.getValue();
                switch(theme){
                    case "Dark":
                        currentTheme = new DarkTheme();
                        break;
                    case "Mystic":
                        currentTheme = new MagicalTheme();
                        break;
                    case "Runic":
                        currentTheme = new RunicTheme();
                        break;
                }

                String res = resOptions.getValue();
                switch(res){
                    case "1280x720":
                        WIDTH = 1280;
                        HEIGHT = 720;
                        break;
                    case "1024x768":
                        WIDTH = 1024;
                        HEIGHT = 768;
                        break;
                    case "1000x800":
                        WIDTH = 1000;
                        HEIGHT = 800;
                        break;
                }
                playGame(primaryStage);
            }
        });

        menu.add(themeSelection, 0, 0);
        menu.add(themeOptions, 1, 0);

        menu.add(resSelection, 0, 1);
        menu.add(resOptions, 1, 1);
        GridPane.setHalignment(play, HPos.CENTER);
        GridPane.setColumnSpan(play, 2);
        menu.add(play, 0, 2);

        Scene mainMenu = new Scene(menu, WIDTH, HEIGHT);

        primaryStage.setScene(mainMenu);
        primaryStage.getIcons().add(new Image("net/thenightwolf/tictactoe/logo.png"));
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
            gc.drawImage(currentTheme.getX_texture(), (WIDTH - BOARD_SIZE) / 2 + ( CELL_SIZE * x), (HEIGHT - BOARD_SIZE) /2 + (CELL_SIZE * y), CELL_SIZE, CELL_SIZE);
        } else if(gameManager.getBoard().getPiece(x,y).getOwner() == Piece.O){
            gc.setEffect(new DropShadow(10, currentTheme.getoGlow()));
            gc.drawImage(currentTheme.getO_texture(), (WIDTH - BOARD_SIZE) / 2 + (CELL_SIZE * x), (HEIGHT - BOARD_SIZE) / 2 + (CELL_SIZE * y), CELL_SIZE, CELL_SIZE);
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
                rectangles.add(new Rectangle((WIDTH - BOARD_SIZE) / 2 + (CELL_SIZE * x), (HEIGHT - BOARD_SIZE) / 2 + (CELL_SIZE * y), CELL_SIZE, CELL_SIZE));
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

    private void playGame(Stage primaryStage) {


        Group root = new Group();

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        gameManager.setPlayersTurn(Piece.X);


        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(new Font(20));

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                gc.setFill(currentTheme.getBackgroundColor());
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                gc.fillRect(0, 0, WIDTH, HEIGHT);
                gc.setEffect(new DropShadow(10, currentTheme.getBoardGlow()));
                gc.drawImage(currentTheme.getBackgroundImage(), 0, 0, WIDTH, HEIGHT);
                gc.drawImage(currentTheme.getBoardImage(), (WIDTH - BOARD_SIZE) / 2, (HEIGHT - BOARD_SIZE) / 2, BOARD_SIZE, BOARD_SIZE);

                drawBoard(gc);

                gc.setEffect(new DropShadow(10, currentTheme.getTextGlow()));
                gc.setFill(currentTheme.getTextColor());
                gc.setTextAlign(TextAlignment.LEFT);
                gc.setFont(new Font(20));
                gc.fillText("Turn: " + (gameManager.getPlayersTurn() == 1 ? 'X' : 'O'), 10, HEIGHT - 10);

                int winner = gameManager.hasPlayerWon();
                if (winner != Piece.EMPTY || gameManager.getBoard().isFull()) {
                    hasWon = true;
                }
                if (hasWon) {
                    gc.setFont(new Font(64));
                    gc.setFill(Color.BLACK);
                    gc.setTextAlign(TextAlignment.CENTER);
                    gc.setEffect(new DropShadow(25, Color.WHITE));
                    if (winner == 0)
                        gc.fillText("CAT has WON!", WIDTH / 2, HEIGHT / 2);
                    else
                        gc.fillText("PLAYER " + (winner == 1 ? 'X' : 'O') + " has WON!", WIDTH / 2, HEIGHT / 2);
                }

            }
        }.start();


        root.getChildren().add(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!hasWon)
                    handleInput(event.getX(), event.getY());
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("Reseting board! " + hasWon + " : " + (event.getCode() == KeyCode.ENTER));
                if (hasWon && event.getCode() == KeyCode.ENTER) {
                    hasWon = false;
                    gameManager.getBoard().resetBoard();
                    gameManager.setPlayersTurn(Piece.X);
                }
            }
        });
        primaryStage.setScene(scene);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }
}
