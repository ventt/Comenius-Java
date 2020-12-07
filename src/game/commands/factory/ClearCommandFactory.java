package game.commands.factory;

import game.commands.ClearCommand;

public class ClearCommandFactory implements CommandFactory<ClearCommand> {
    @Override
    public ClearCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("clear".equals(split[0])) {
            return new ClearCommand();
        }
        return null;
    }
}
