package game.commands;

import game.Core;
import game.Position;
import game.Rotation;
import game.draw.Line;

public class MoveCommand implements Command {
    final private int steps;

    public MoveCommand(int steps) {
        this.steps = steps;
    }

    private Position movement(Position current, int steps, Rotation dir) {
        switch (dir) {
            case FORWARD:
                return new Position(current.getX(), current.getY() + steps);
            case RIGHT:
                return new Position(current.getX() + steps, current.getY());
            case BACKWARD:
                return new Position(current.getX(), current.getY() - steps);
            case LEFT:
                return new Position(current.getX() - steps, current.getY());
            default:
                throw new IllegalArgumentException("Wrong direction");
        }
    }

    private void Move(int steps, Core core) {
        if (!core.getElf().getPen().isDrawing()) {
            core.getElf().setCurrent(movement(core.getElf().getPosition(), steps, core.getElf().getOrientation()));

        } else {
            Position newPos = movement(core.getElf().getPosition(), steps, core.getElf().getOrientation());
            Line obj = new Line(core.getElf().getPosition(), newPos, core.getElf().getPen().getColor(), core.getElf().getPen().getPenThickness()); /// !!!
            core.getElf().setCurrent(newPos);
            core.getDraws().add(obj);
        }
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public void method(Core core) {
        Move(steps, core);
    }

    @Override
    public String toString() {
        return "Move command: elf took " + steps + " step(s)!";
    }
}
