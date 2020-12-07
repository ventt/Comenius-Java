package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.Rotation;

/**
 * Megadott írányba állítja a JdkElf-et, Command implementációja. Tárolja az irányt.
 */
public class RotateCommand implements Command {
    final private Rotation rotation;

    /**
     * Konstruktor.
     *
     * @param rotation irányt.
     */
    public RotateCommand(Rotation rotation) {
        this.rotation = rotation;
    }

    /**
     * Beállítja a JdkElf-ben tárolt irányt az osztály által tárolt irányra.
     *
     * @param rotation irány.
     */
    private void rotate(Rotation rotation) {
        Core.getInstance().getElf().setOrientation(rotation);
    }

    /**
     * Meghívja a rotate() metódust.
     */
    @Override
    public void apply() {
        rotate(rotation);
    }

    @Override
    public String toString() {
        return "Rotation Command: JdkElf has the orientation of: " + rotation + "!";
    }
}
