package game;

import view.MyCanvas;

import java.awt.geom.Point2D;

public class Position {
    private final int x;
    private final int y;

    public Position() {
        x = y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point2D toPoint(double canvasWidth, double canvasHeight, double scale) {
        return new Point2D.Double(scale * (double) x + canvasWidth / 2.0, canvasHeight / 2.0 - scale * (double) y);
    }

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
