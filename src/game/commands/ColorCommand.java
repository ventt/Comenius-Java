package game.commands;

import game.Core;
import game.commands.Command;
import model.MyColor;

public class ColorCommand implements Command {
    final private MyColor colour;

    public ColorCommand(MyColor colour) {
        this.colour = colour;
    }

    private void setColour(MyColor colour, Core core) {
        core.getElf().getPen().setColour(colour);
    }

    @Override
    public void method(Core core) {
        setColour(colour, core);
    }

    @Override
    public String toString() {
        return "Color Command: Pen color set: "+colour+"!";
    }
}
