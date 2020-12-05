package game;

import model.MyColor;

import java.awt.*;

public class Line extends DrawObject {

    private Position endPos;

    public Line(Position startPos, Position endPos, MyColor colour, int thickness ){
        this.startPos = startPos;
        this.endPos = endPos;
        this.thickness = thickness;
        this.colour = colour;

    }
    //public Line(Position current, Position newPos, MyColor colour, int penThickness){}

    public void setEndPos(Position endPos) {
        this.endPos = endPos;
    }

    public Position getEndPos() {
        return endPos;
    }


    @Override
    public String toString() {
        return "Line{" +
                "startPos=" + startPos +
                "endPos=" + endPos +
                ", colour='" + colour + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
