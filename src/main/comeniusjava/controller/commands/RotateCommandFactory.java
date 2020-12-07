package comeniusjava.controller.commands;


import comeniusjava.game.Rotation;
import comeniusjava.game.commands.RotateCommand;

public class RotateCommandFactory implements CommandFactory<RotateCommand> {
    @Override
    public RotateCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("rotate".equals(split[0])) {
            return new RotateCommand(Rotation.valueOf(split[1].toUpperCase()));
        }
        return null;
    }
}
