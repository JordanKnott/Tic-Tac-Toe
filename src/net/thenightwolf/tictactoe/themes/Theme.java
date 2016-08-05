package net.thenightwolf.tictactoe.themes;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Created by burni_000 on 8/5/2016.
 */
public class Theme {

    protected Image backgroundImage;
    protected Color backgroundColor;
    protected Image boardImage;
    protected Image x_texture;
    protected Image o_texture;
    protected Color boardGlow;
    protected Color xGlow;
    protected Color oGlow;
    protected Color textColor;
    protected Color textGlow;
    protected String themeName;

    public String getThemeName() {
        return themeName;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public Image getBoardImage() {
        return boardImage;
    }

    public Image getX_texture() {
        return x_texture;
    }

    public Image getO_texture() {
        return o_texture;
    }

    public Color getBoardGlow() {
        return boardGlow;
    }

    public Color getxGlow() {
        return xGlow;
    }

    public Color getoGlow() {
        return oGlow;
    }

    public Color getTextGlow() {
        return textGlow;
    }

}
