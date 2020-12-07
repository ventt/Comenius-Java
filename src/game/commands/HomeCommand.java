package game.commands;

import game.Core;

public class HomeCommand implements Command {

    @Override
    public void method(Core core) {
        core.getElf().setHome();
    }

    @Override
    public String toString() {
        return "JdkElf set home!(0.0)";
    }
}
