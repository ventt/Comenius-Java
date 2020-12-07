package game.commands.factory;

import game.commands.HomeCommand;

public class HomeCommandFactory implements CommandFactory<HomeCommand> {
    @Override
    public HomeCommand createFromText(String input) throws Exception {
        String[] split = input.toLowerCase().split(" ");
        if ("home".equals(split[0])) {
            return new HomeCommand();
        }
        return null;
    }
}
