package comeniusjava.controller.commands;


import comeniusjava.game.color.GameColor;
import comeniusjava.game.commands.ColorCommand;

public class ColorCommandFactory implements CommandFactory<ColorCommand> {
    /**
     * {@inheritDoc}
     */
    @Override
    public ColorCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("color".equals(split[0])) {
            return new ColorCommand(GameColor.getColorFromString(split[1].toUpperCase()));
        }
        return null;
    }
}
