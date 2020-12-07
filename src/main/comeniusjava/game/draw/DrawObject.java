package comeniusjava.game.draw;

import comeniusjava.game.Position;

import java.awt.*;

public abstract class DrawObject {
    protected final Position startPos;
    protected final Color color;
    protected final int thickness;

    public DrawObject(Position startPos, Color color, int thickness) {
        this.startPos = startPos;
        this.color = color;
        this.thickness = thickness;
    }

    public Position getStartPos() {
        return startPos;
    }

    public Color getColor() {
        return color;
    }

    public int getThickness() {
        return thickness;
    }
}
