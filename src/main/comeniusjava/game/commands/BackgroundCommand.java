package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.color.ApplicationColor;

import java.awt.*;

public class BackgroundCommand implements Command {
    private final Color color;

    public BackgroundCommand(Color color) {
        this.color = color;
    }

    @Override
    public void apply() {
        Core.getInstance().setBackGroundColor(color);
    }

    @Override
    public String toString() {
        return "Background color: " + ApplicationColor.getByColor(color).name() + "! ";
    }
}
