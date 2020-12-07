package comeniusjava.game.commands;


import comeniusjava.game.Core;

public class DrawingCommand implements Command {
    final private boolean isDrawing;

    public DrawingCommand(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

    private void rotate(boolean isDrawing, Core core) {
        core.getElf().getPen().setDrawing(isDrawing);
    }

    @Override
    public void apply(Core core) {
        rotate(isDrawing, core);
    }

    @Override
    public String toString() {
        return "DrawingCommand{" +
                "isDrawing=" + isDrawing +
                '}';
    }
}
