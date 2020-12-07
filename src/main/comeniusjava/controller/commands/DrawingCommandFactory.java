package comeniusjava.controller.commands;


import comeniusjava.game.commands.DrawingCommand;

public class DrawingCommandFactory implements CommandFactory<DrawingCommand> {
    @Override
    public DrawingCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("pen".equals(split[0])) {
            if ("down".equalsIgnoreCase(split[1])) {
                return new DrawingCommand(true);
            } else if ("up".equalsIgnoreCase(split[1])) {
                return new DrawingCommand(false);
            }
        }
        return null;
    }
}
