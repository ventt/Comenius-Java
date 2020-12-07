package comeniusjava.game.commands;


import comeniusjava.game.Core;

public class HomeCommand implements Command {

    @Override
    public void apply() {
        Core.getInstance().getElf().setHome();
    }

    @Override
    public String toString() {
        return "JdkElf set home!(0.0)";
    }
}
