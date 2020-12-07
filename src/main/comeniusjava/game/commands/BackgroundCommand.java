package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.color.GameColor;

import java.awt.*;

/**
 * Háttérszínt állító parancs, Command implementációja. Szín-t tárol.
 */
public class BackgroundCommand implements Command {
    private final Color color;

    /**
     * Konstruktor.
     *
     * @param color az osztály által tárolt szín.
     */
    public BackgroundCommand(Color color) {
        this.color = color;
    }

    /**
     * Core-ban beállítja a háttér színét.
     */
    @Override
    public void apply() {
        Core.getInstance().setBackGroundColor(color);
    }

    @Override
    public String toString() {
        return "Background color: " + GameColor.getByColor(color).name() + "! ";
    }
}
