package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.JdkElf;
import comeniusjava.game.draw.Circle;

public class CircleCommand implements Command {
    private final int radius;

    public CircleCommand(int radius) {
        this.radius = radius;
    }

    @Override
    public void apply(Core core) {
        final JdkElf elf = Core.getInstance().getElf();
        core.getDraws().add(new Circle(elf.getPosition(), radius, elf.getPen().getColor(), elf.getPen().getPenThickness()));
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}
