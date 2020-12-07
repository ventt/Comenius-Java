package comeniusjava.game.commands;


import comeniusjava.game.Core;

/**
 * Osztály által tárolt vastagságúra állítja a toll vastagságát, Command implementációja. Tárolja a vastagságot.
 */
public class ThicknessCommand implements Command {
    final private int thickness;

    /**
     * Konstruktor.
     *
     * @param thickness vastagság.
     */
    public ThicknessCommand(int thickness) {
        this.thickness = thickness;
    }

    /**
     * Beállítja a JdkElf által tárolt Pen osztályban a vastagságot az osztály által tárolt vastagságra.
     *
     * @param thickness vastagság.
     */
    private void setThickness(int thickness) {
        Core.getInstance().getElf().getPen().setPenThickness(thickness);
    }

    /**
     * Meghívja a setThickness() metódust.
     */
    @Override
    public void apply() {
        setThickness(thickness);
    }

    @Override
    public String toString() {
        return "Thickness Command: the pen thickness set: " + thickness + " pixel(s) wide";
    }
}
