import controller.WindowController;
import game.Core;
import game.Orientation;
import game.commands.*;
import view.*;

public class Application {

    private static WindowView windowView;
    public static void main(String[] args) {
        Core core = Core.getInstance();
        WindowController windowController = new WindowController();



      /*  ThicknessCommand t1 = new ThicknessCommand(6);
        MoveCommand m1 = new MoveCommand(12);
        RotationCommand r1 = new RotationCommand(Orientation.EAST);
        ColorCommand c1 = new ColorCommand("BLUE");
        DrawingCommand d1 = new DrawingCommand(true);
        MoveCommand m2 = new MoveCommand(5);
        ThicknessCommand t2 = new ThicknessCommand(3);
        ColorCommand c2 = new ColorCommand("RED");
        //UndoCommand u1 = new UndoCommand();
        RotationCommand r2 = new RotationCommand(Orientation.SOUTH);
        MoveCommand m3 = new MoveCommand(12);
        HomeCommand h1 = new HomeCommand();
        core.addCommands(t1);

        core.addCommands(m1);

        core.addCommands(r1);

        core.addCommands(c1);

        core.addCommands(d1);

        core.addCommands(m2);

        core.addCommands(t2);

        core.addCommands(c2);

        //core.addCommands(u1);

        core.addCommands(r2);

        //core.addCommands(m3);
       // core.addCommands(h1);

        core.doCommands();
        core.showDrawnObjects();*/



    }
}
