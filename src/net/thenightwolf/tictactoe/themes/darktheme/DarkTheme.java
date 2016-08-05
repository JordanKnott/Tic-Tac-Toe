package net.thenightwolf.tictactoe.themes.darktheme;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import net.thenightwolf.tictactoe.themes.Theme;

/**
 * Created by burni_000 on 8/5/2016.
 */
public class DarkTheme extends Theme {

    private String pkg = "net/thenightwolf/tictactoe/themes/darktheme/";

    public DarkTheme(){
        super.themeName = "Dark";
        super.backgroundColor = Color.BLACK;
        super.boardImage = new Image(pkg + "tic-tac-toe_white.png");
        super.boardGlow = Color.PURPLE;
        super.x_texture = new Image(pkg + "rune_one.png");
        super.xGlow = Color.CYAN;
        super.o_texture = new Image(pkg + "rune_two.png");
        super.oGlow = Color.RED;
        super.textColor = Color.WHITE;
    }

}
