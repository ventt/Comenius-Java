package comeniusjava.game.commands;


import comeniusjava.game.Core;

/**
 * Toll állapotát megadó parancs, Command implementációja. (Up/Down)
 */
public class DrawingCommand implements Command {
    final private boolean isDrawing;

    /**
     * Konstruktor
     *
     * @param isDrawing boolean érték.
     */
    public DrawingCommand(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

    /**
     * Átállítja a toll állapotát, le vagy fel.
     *
     * @param isDrawing boolean érték.
     */
    private void rotate(boolean isDrawing) {
        Core.getInstance().getElf().getPen().setDrawing(isDrawing);
    }

    /**
     * Meghívja a rotate() metódust.
     */
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
