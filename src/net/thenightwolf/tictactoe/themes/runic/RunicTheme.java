package net.thenightwolf.tictactoe.themes.runic;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import net.thenightwolf.tictactoe.themes.Theme;

/**
 * Created by burni_000 on 8/5/2016.
 */
public class RunicTheme extends Theme {

    private String pkg = "net/thenightwolf/tictactoe/themes/runic/";

    public RunicTheme(){
        super.themeName = "Runic";
        super.backgroundColor = Color.BLACK;
        super.backgroundImage = new Image(pkg + "runic.jpg");
        super.boardImage = new Image(pkg + "tic-tac-toe_white.png");
        super.boardGlow = Color.PINK;
        super.x_texture = new Image(pkg + "necro_rune.png");
        super.xGlow = Color.RED;
        super.o_texture = new Image(pkg + "light_rune.png");
        super.oGlow = Color.WHITESMOKE;
        super.textColor = Color.WHITE;
    }

}
