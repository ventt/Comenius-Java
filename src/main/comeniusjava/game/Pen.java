package comeniusjava.game;

import java.awt.*;

/**
 * A toll adatait tároló osztály.
 */
public class Pen {
    private boolean isDrawing = false;
    private Color color = Color.BLACK;
    private int penThickness = 1;

    /**
     * Csak a package által látható konstruktor.
     */
    Pen() {
    }

    /**
     * @return lent van-e a toll.
     */
    public boolean isDrawing() {
        return isDrawing;
    }

    /**
     * Up/Down
     *
     * @param drawing frissiti az aktuális helyzetét.
     */
    public void setDrawing(boolean drawing) {
        isDrawing = drawing;
    }

    /**
     * @return a toll színét.
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color a toll színét, és beállítja.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return a toll vastagságát
     */
    public int getPenThickness() {
        return penThickness;
    }

    /**
     * @param penThickness a toll vastagságát, és beállítja.
     */
    public void setPenThickness(int penThickness) {
        this.penThickness = penThickness;
    }

    /**
     * Visszaállítja a toll osztályt alaphelyzetbe.
     */
    public void penSetDefault() {
        isDrawing = false;
        color = Color.BLACK;
        penThickness = 1;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "upDown=" + isDrawing +
                ", colour='" + color + '\'' +
                ", penThickness=" + penThickness +
                '}';
    }
}
