package net.thenightwolf.tictactoe.themes.magical;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import net.thenightwolf.tictactoe.themes.Theme;

/**
 * Created by burni_000 on 8/5/2016.
 */
public class MagicalTheme extends Theme {
    private String pkg = "net/thenightwolf/tictactoe/themes/magical/";

    public MagicalTheme(){
        super.themeName = "Magical";
        super.backgroundColor = Color.WHITE;
        super.backgroundImage = new Image(pkg + "magical.jpg");
        super.boardImage = new Image(pkg + "tic-tac-toe.png");
        super.boardGlow = Color.MAGENTA;
        super.x_texture = new Image(pkg + "cyanRune.png");
        super.xGlow = Color.TURQUOISE;
        super.o_texture = new Image(pkg + "greenRune.png");
        super.oGlow = Color.PINK;
        super.textColor = Color.BLACK;
        super.textGlow = Color.PURPLE;
    }
}
