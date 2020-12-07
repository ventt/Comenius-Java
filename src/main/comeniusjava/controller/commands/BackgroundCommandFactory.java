package comeniusjava.controller.commands;


import comeniusjava.game.color.GameColor;
import comeniusjava.game.commands.BackgroundCommand;

import java.awt.*;

public class BackgroundCommandFactory implements CommandFactory<BackgroundCommand> {
    /**
     * {@inheritDoc}
     */
    @Override
    public BackgroundCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("background".equals(split[0])) {
            if ("default".equals(split[1])) {
                return new BackgroundCommand(Color.lightGray);
            } else {
                return new BackgroundCommand(GameColor.getColorFromString(split[1].toUpperCase()));
            }
        }
        return null;
    }
}
