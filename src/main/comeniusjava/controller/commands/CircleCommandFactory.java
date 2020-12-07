package comeniusjava.controller.commands;


import comeniusjava.game.commands.CircleCommand;

public class CircleCommandFactory implements CommandFactory<CircleCommand> {
    /**
     * {@inheritDoc}
     */
    @Override
    public CircleCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("circle".equals(split[0])) {
            return new CircleCommand(Integer.parseInt(split[1]));
        }
        return null;
    }
}
