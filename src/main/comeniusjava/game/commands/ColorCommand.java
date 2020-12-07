package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.color.ApplicationColor;

import java.awt.*;

/**
 * Toll színét megadó parancs, Command implementációja. Tárolja a színt.
 */
public class ColorCommand implements Command {
    final private Color color;

    /**
     * Konstruktor
     *
     * @param color a szín.
     */
    public ColorCommand(Color color) {
        this.color = color;
    }

    /**
     * Beállítja az osztály által tárolt színt a tollon.
     *
     * @param color a színt.
     */
    private void setColor(Color color) {
        Core.getInstance().getElf().getPen().setColor(color);
    }

    /**
     * Meghívja a setColor() metódust.
     */
    @Override
    public void apply() {
        setColor(color);
    }

    @Override
    public String toString() {
        return "Color Command: Pen color set: " + ApplicationColor.getByColor(color).name() + "!";
    }
}
