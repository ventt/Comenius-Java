package game.commands;

import game.Core;
import game.commands.Command;

public class ColorCommand implements Command {
    final private String colour;

    public ColorCommand(String colour) {
        this.colour = colour;
    }

    private void setColour(String colour, Core core) {
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
