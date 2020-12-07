package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.Position;
import comeniusjava.game.Rotation;
import comeniusjava.game.draw.Line;

/**
 * Megadott pozicióra mozgatja a JdkElf-et, ha a toll állapota: lent, akkor vonal alakzatot hozz létre, és hozzá adja
 * a Core-ban tárolt alakzatok, draws listához, Command implementációja. Tárolja a lépések számát.
 */
public class MoveCommand implements Command {
    final private int steps;

    /**
     * Konstruktor.
     *
     * @param steps lépéseke száma.
     */
    public MoveCommand(int steps) {
        this.steps = steps;
    }

    /**
     * Meghatározza az irányból és a lépések számából a koordináta rendszer pontjait.
     *
     * @param current jelenlegi pozició.
     * @param steps   lépések száma.
     * @param dir     irány.
     * @return Új poziciót, nemlétező irány esetén IllegalArgumentException-t.
     */
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

    /**
     * Elmozgatja a JdkElf-et a megadott lépések számával, a JdkElf által megadott irányba, ha lent van a toll
     * vonal alakzatot hozz létre.
     *
     * @param steps lépések
     */
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

    /**
     * Meghívja a Move() metódust.
     */
    @Override
    public void apply() {
        Move(steps);
    }

    @Override
    public String toString() {
        return "Move command: elf took " + steps + " step(s)!";
    }
}
