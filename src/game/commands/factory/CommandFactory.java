package game.commands.factory;

import game.commands.Command;

public interface CommandFactory<T extends Command> {
    T createFromText(String input) throws Exception;
}
