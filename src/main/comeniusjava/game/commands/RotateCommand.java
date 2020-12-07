package comeniusjava.game.commands;


import comeniusjava.game.Core;
import comeniusjava.game.Rotation;

public class RotateCommand implements Command {
    final private Rotation rotation;

    public RotateCommand(Rotation rotation) {
        this.rotation = rotation;
    }

    public Rotation getOrientation() {
        return rotation;
    }

    private void rotate(Rotation rotation, Core core) {
        core.getElf().setOrientation(rotation);
    }

    @Override
    public void apply(Core core) {
        rotate(rotation, core);
    }

    @Override
    public String toString() {
        return "Rotation Command: JdkElf has the orientation of: " + rotation + "!";
    }
}
