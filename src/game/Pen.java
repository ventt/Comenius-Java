package game;

import java.awt.*;

public class Pen {
    //singleton
    private static final Pen instance = new Pen();
    private boolean isDrawing = false;
    private Color color = Color.BLACK;
    private int penThickness = 1;

    private Pen() {
    }

    public static Pen getInstance() {
        return instance;
    }


    public boolean isDrawing() {
        return isDrawing;
    }

    public void setDrawing(boolean drawing) {
        isDrawing = drawing;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPenThickness() {
        return penThickness;
    }

    public void setPenThickness(int penThickness) {
        this.penThickness = penThickness;
    }

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
