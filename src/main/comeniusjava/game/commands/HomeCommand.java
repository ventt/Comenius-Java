package comeniusjava.game.commands;


import comeniusjava.game.Core;

/**
 * A JdkElf-et a 0.0 pozicióra állító parancs, Command implementációja.
 */
public class HomeCommand implements Command {
    /**
     * meghívja az elf osztályon a setHome() metódust.
     */
    @Override
    public void apply() {
        Core.getInstance().getElf().setHome();
    }

    @Override
    public String toString() {
        return "JdkElf set home!(0.0)";
    }
}
