package game;

import java.awt.*;

//ős osztálya minden rajzobjektumnak
public class DrawObject {
    protected Position startPos;
    protected Color color;
    protected int thickness;

    public Position getStartPos() {
        return startPos;
    }

    public void setStartPos(Position startPos) {
        this.startPos = startPos;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "DrawObject{" +
                "startPos=" + startPos +
                ", colour='" + color.toString() + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
