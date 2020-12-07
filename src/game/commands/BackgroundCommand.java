package game.commands;

import game.Core;
import game.color.ApplicationColor;

import java.awt.*;

public class BackgroundCommand implements Command {
    Color color;

    public BackgroundCommand(Color color) {
        this.color = color;
    }

    @Override
    public void method(Core core) {
        core.setBackGroundColor(color);
    }

    @Override
    public String toString() {
        return "Background color: " + ApplicationColor.getByColor(color).name() + "! ";
    }
}
