package comeniusjava.game;

import comeniusjava.view.MyCanvas;

import java.awt.geom.Point2D;

/**
 * Pozició osztály  x,y int-eket tárol, és az őket megvalósító metódusokat.
 */
public class Position {
    private final int x;
    private final int y;

    /**
     * default konstruktor.
     */
    public Position() {
        x = y = 0;
    }

    /**
     * Konstruktor.
     *
     * @param x tengelyen lévő pozició.
     * @param y tengelyen lévő pozició.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x tengely értékét.
     */
    public int getX() {
        return x;
    }

    /**
     * @return y tengely értékét.
     */
    public int getY() {
        return y;
    }

    /**
     * Átalakítja az origót a képernyő Bal felső sarkába a képernyő közepében megadott koordinátákból.
     *
     * @param canvasWidth  a képernyő szélessége
     * @param canvasHeight a képernyő magassága
     * @param scale        a nagyító szorzó
     * @return AWT grafikához kompatibilis koordináták
     */
    public Point2D toPoint(double canvasWidth, double canvasHeight, double scale) {
        return new Point2D.Double(
                scale * (double) x + canvasWidth / 2.0,
                canvasHeight / 2.0 - scale * (double) y
        );
    }

    /**
     * Átalakítja az origót a képernyő Bal felső sarkába a képernyő közepében megadott koordinátákból.
     *
     * @param myCanvas a képernyő
     * @return AWT grafikához kompatibilis koordináták
     */
    public Point2D toPoint(MyCanvas myCanvas) {
        return toPoint(myCanvas.getWidth(), myCanvas.getHeight(), myCanvas.getScale());
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
