package game.commands;

import game.Core;
import game.JdkElf;
import game.draw.Circle;

public class CircleCommand implements Command {
    private final int radius;

    public CircleCommand(int radius) {
        this.radius = radius;
    }

    @Override
    public void method(Core core) {
        final JdkElf elf = Core.getInstance().getElf();
        core.getDraws().add(new Circle(elf.getPosition(), radius, elf.getPen().getColor(), elf.getPen().getPenThickness()));
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}
