package comeniusjava.controller.commands;


import comeniusjava.game.color.ColorHelper;
import comeniusjava.game.commands.BackgroundCommand;

import java.awt.*;

public class BackgroundCommandFactory implements CommandFactory<BackgroundCommand> {
    @Override
    public BackgroundCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("background".equals(split[0])) {
            if ("default".equals(split[1])) {
                return new BackgroundCommand(Color.lightGray);
            } else {
                return new BackgroundCommand(ColorHelper.getColorFromString(split[1].toUpperCase()));
            }
        }
        return null;
    }
}
