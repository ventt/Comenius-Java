package comeniusjava.controller.commands;


import comeniusjava.game.commands.Command;

public interface CommandFactory<T extends Command> {
    T createFromText(String input) throws Exception;
}
