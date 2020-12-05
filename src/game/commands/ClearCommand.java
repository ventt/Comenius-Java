package game.commands;

import game.Core;
import game.commands.Command;

public class ClearCommand implements Command {
    @Override
    public void method(Core core) {
        core.clear();
    }

    @Override
    public String toString() {
        return "Clear command: draws were cleaned!";
    }
}
