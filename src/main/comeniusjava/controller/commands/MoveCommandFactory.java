package comeniusjava.controller.commands;


import comeniusjava.game.commands.MoveCommand;

public class MoveCommandFactory implements CommandFactory<MoveCommand> {
    /**
     * {@inheritDoc}
     */
    @Override
    public MoveCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("move".equals(split[0])) {
            return new MoveCommand(Integer.parseInt(split[1]));
        }
        return null;
    }
}
