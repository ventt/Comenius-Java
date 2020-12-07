package game.commands.factory;

import game.color.ColorHelper;
import game.commands.ColorCommand;

public class ColorCommandFactory implements CommandFactory<ColorCommand> {
    @Override
    public ColorCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("color".equals(split[0])) {
            return new ColorCommand(ColorHelper.getColorFromString(split[1].toUpperCase()));
        }
        return null;
    }
}
