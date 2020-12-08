package comeniusjava.controller;


import comeniusjava.controller.commands.*;
import comeniusjava.game.Core;
import comeniusjava.game.commands.Command;

/**
 * Parancsfordító
 */
public class CommandTranslator {
    private static final CommandFactory[] commandFactories = {
            new BackgroundCommandFactory(),
            new CircleCommandFactory(),
            new ColorCommandFactory(),
            new DrawingCommandFactory(),
            new HomeCommandFactory(),
            new MoveCommandFactory(),
            new RotateCommandFactory(),
            new ThicknessCommandFactory(),
    };

    /**
     * Végig megy a commandFactory-kon, amelyik nem null-al tér vissza azt visszadja
     *
     * @param input parancs
     * @return command || null
     * @throws Exception
     */
    private static Command getCommand(String input) throws Exception {
        for (CommandFactory commandFactory : commandFactories) {
            Command command = commandFactory.createFromText(input);
            if (command != null) {
                return command;
            }
        }
        return null;
    }

    /**
     * Fordítja a command class nélküli parancsokat
     *
     * @param input parancs
     * @throws Exception
     */
    public void translate(String input) throws Exception {
        Command command = getCommand(input);
        if (command == null) {
            String[] s = input.split(" ");
            switch (s[0].toLowerCase()) {
                case "clear":
                    Core.getInstance().clear();
                case "undo":
                    if (Core.getInstance().getCommands().size() > 0)
                        Core.getInstance().getCommands().remove(Core.getInstance().getCommands().size() - 1);
                    break;
                case "save":
                    Core.getInstance().save("save.txt");
                    break;
                case "load":
                    Core.getInstance().load(s[1]);
                    break;
                default:
                    throw new InvalidCommandException(input);
            }
        } else {
            Core.getInstance().getCommands().add(command);
        }
        Core.getInstance().doCommands();
    }
}
