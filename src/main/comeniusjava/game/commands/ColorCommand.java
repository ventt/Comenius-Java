package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.color.ApplicationColor;

import java.awt.*;

public class ColorCommand implements Command {
    final private Color color;

    public ColorCommand(Color color) {
        this.color = color;
    }

    private void setColour(Color color, Core core) {
        core.getElf().getPen().setColor(color);
    }

    @Override
    public void apply(Core core) {
        setColour(color, core);
    }

    @Override
    public String toString() {
        return "Color Command: Pen color set: " + ApplicationColor.getByColor(color).name() + "!";
    }
}
