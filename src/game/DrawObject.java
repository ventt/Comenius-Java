package game;

import java.awt.*;

//ős osztálya minden rajzobjektumnak
public class DrawObject {
    protected Position startPos;
    protected Color color;
    protected int thickness;
    // protected LocalTime creationTime;

    public void setStartPos(Position startPos) {
        this.startPos = startPos;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setThickness(int thickness) {
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

    @Override
    public String toString() {
        return "DrawObject{" +
                "startPos=" + startPos +
                ", colour='" + color.toString() + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
