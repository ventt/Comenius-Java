package comeniusjava.game.commands;


import comeniusjava.game.Core;

public class ThicknessCommand implements Command {
    final private int thickness;

    public ThicknessCommand(int thickness) {
        this.thickness = thickness;
    }

    private void setThickness(int thickness) {
        Core.getInstance().getElf().getPen().setPenThickness(thickness);
    }

    @Override
    public void apply() {
        setThickness(thickness);
    }

    @Override
    public String toString() {
        return "Thickness Command: the pen thickness set: " + thickness + " pixel(s) wide";
    }
}
