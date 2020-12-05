package game.commands;

import game.Core;
import game.Orientation;
import game.commands.Command;

public class RotationCommand implements Command {
    final private Orientation orientation;
    public RotationCommand(Orientation orientation){this.orientation = orientation;}

    public Orientation getOrientation() {
        return orientation;
    }
    private void rotate(Orientation orientation, Core core){
        core.getElf().setOrientation(orientation);
    }

    @Override
    public void method(Core core) {
        rotate(orientation,core);
    }

    @Override
    public String toString() {
        return "Rotation Command: JdkElf has the orientation of: "+orientation+"!";
    }
}
