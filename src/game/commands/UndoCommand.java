package game.commands;

import game.Core;

public class UndoCommand implements Command {
    @Override
    public void method(Core core) {
        core.undo();
    }

    @Override
    public String toString() {
        return "Previous command were undo!";
    }
}
