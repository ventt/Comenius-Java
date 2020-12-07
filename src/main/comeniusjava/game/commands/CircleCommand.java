package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.JdkElf;
import comeniusjava.game.draw.Circle;

/**
 * Kört rajzoló parancs, Command implementációja. A kör sugarát tárolja.
 */
public class CircleCommand implements Command {
    private final int radius;

    /**
     * Konstruktor
     *
     * @param radius az osztály által tárolt kör sugara.
     */
    public CircleCommand(int radius) {
        this.radius = radius;
    }

    /**
     * Új kört add az alakzatok listájába, a JdkElf poziciója a közzéppont.
     */
    @Override
    public void apply() {
        final JdkElf elf = Core.getInstance().getElf();
        Core.getInstance().getDraws().add(new Circle(elf.getPosition(), radius, elf.getPen().getColor(), elf.getPen().getPenThickness()));
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}
