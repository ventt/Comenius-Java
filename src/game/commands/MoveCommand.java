package game.commands;

import game.*;

public class MoveCommand implements Command {
    final private int steps;
    public MoveCommand(int steps){this.steps = steps;}

    private Position movement(Position current, int steps, Orientation dir){
        Position newPos = new Position(current.getX(), current.getY());  // !!!
        switch (dir){
            case NORTH:
                newPos.setY(current.getY()+steps);
                break;
            case EAST:
                newPos.setX(current.getX()+steps);
                break;
            case SOUTH:
                newPos.setY(current.getY()-steps);
                break;
            case WEST:
                newPos.setX(current.getX()-steps);
                break;
            default:
                break;
        }
        return newPos;
    }
    private void Move ( int steps, Core core){
        if (!core.getElf().getPen().isDrawing()) {
            core.getElf().setCurrent(movement(core.getElf().getCurrent(), steps, core.getElf().getOrientation()));

        } else {
            Position newPos = movement(core.getElf().getCurrent(), steps, core.getElf().getOrientation());
            Line obj = new Line(core.getElf().getCurrent(), newPos, core.getElf().getPen().getColor(), core.getElf().getPen().getPenThickness()); /// !!!
            core.getElf().setCurrent(newPos);
            core.addDraws(obj);
        }
    }
    public int getSteps() {
        return steps;
    }
    @Override
    public void method(Core core) {
        Move(steps,core);
    }

    @Override
    public String toString() {
        return "Move command: elf took "+ steps+" step(s)!";
    }
}
