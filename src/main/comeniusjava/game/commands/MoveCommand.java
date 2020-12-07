package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.Position;
import comeniusjava.game.Rotation;
import comeniusjava.game.draw.Line;

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

    private void Move(int steps) {
        if (!Core.getInstance().getElf().getPen().isDrawing()) {
            Core.getInstance().getElf().setPosition(movement(Core.getInstance().getElf().getPosition(), steps, Core.getInstance().getElf().getOrientation()));

        } else {
            Position newPos = movement(Core.getInstance().getElf().getPosition(), steps, Core.getInstance().getElf().getOrientation());
            Line obj = new Line(Core.getInstance().getElf().getPosition(), newPos, Core.getInstance().getElf().getPen().getColor(), Core.getInstance().getElf().getPen().getPenThickness()); /// !!!
            Core.getInstance().getElf().setPosition(newPos);
            Core.getInstance().getDraws().add(obj);
        }
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public void apply() {
        Move(steps);
    }

    @Override
    public String toString() {
        return "Move command: elf took " + steps + " step(s)!";
    }
}
