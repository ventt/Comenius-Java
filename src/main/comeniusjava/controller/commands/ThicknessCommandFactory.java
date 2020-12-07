package comeniusjava.controller.commands;


import comeniusjava.game.commands.ThicknessCommand;

public class ThicknessCommandFactory implements CommandFactory<ThicknessCommand> {
    /**
     * {@inheritDoc}
     */
    @Override
    public ThicknessCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("pen".equals(split[0])) {
            if ("thickness".equalsIgnoreCase(split[1])) {
                return new ThicknessCommand(Integer.decode(split[2]));
            }
        }
        return null;
    }
}
