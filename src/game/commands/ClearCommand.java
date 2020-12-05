package game.commands;

import game.Core;
import game.commands.Command;

public class ClearCommand implements Command {
    @Override
    public void method(Core core) {
        core.clearDraws();
    }

    @Override
    public String toString() {
        return "Clear command: draws were cleaned!";
    }
}
