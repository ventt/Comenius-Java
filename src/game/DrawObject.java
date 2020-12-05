package game;

import model.MyColor;

import java.awt.*;

//ős osztálya minden rajzobjektumnak
public class DrawObject {
    protected Position startPos;
    protected MyColor colour;
    protected int thickness;
   // protected LocalTime creationTime;

    public void setStartPos(Position startPos) {
        this.startPos = startPos;
    }
    public void setColour(MyColor colour) {
        this.colour = colour;
    }
    public void setThickness(int thickness) { this.thickness = thickness;}

    public Position getStartPos() {
        return startPos;
    }
    public MyColor getColour() {
        return colour;
    }
    public int getThickness() { return thickness;}

    @Override
    public String toString() {
        return "DrawObject{" +
                "startPos=" + startPos +
                ", colour='" + colour.getColorString(colour.getColor()) + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
