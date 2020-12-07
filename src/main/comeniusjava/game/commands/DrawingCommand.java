package comeniusjava.game.commands;


import comeniusjava.game.Core;

public class DrawingCommand implements Command {
    final private boolean isDrawing;

    public DrawingCommand(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

    private void rotate(boolean isDrawing) {
        Core.getInstance().getElf().getPen().setDrawing(isDrawing);
    }

    @Override
    public void apply() {
        rotate(isDrawing);
    }

    @Override
    public String toString() {
        return "DrawingCommand{" +
                "isDrawing=" + isDrawing +
                '}';
    }
}
