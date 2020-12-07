package comeniusjava.game.draw;

import comeniusjava.game.Position;

import java.awt.*;

/**
 * Minden alakzat ős osztálya.
 */
public abstract class DrawObject {
    protected final Position startPos;
    protected final Color color;
    protected final int thickness;

    /**
     * Konstruktor
     *
     * @param startPos  kezdő pozició.
     * @param color     alakzat vonal színe.
     * @param thickness alakzat vonal vastagsága.
     */
    public DrawObject(Position startPos, Color color, int thickness) {
        this.startPos = startPos;
        this.color = color;
        this.thickness = thickness;
    }

    /**
     * @return alakzat kezdő pozicióját.
     */
    public Position getStartPos() {
        return startPos;
    }

    /**
     * @return alakzat vonalának a színét.
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return alazkat vonalának a vastagságát.
     */
    public int getThickness() {
        return thickness;
    }
}
