package game;

import java.awt.*;

public class Line extends DrawObject {

    private Position endPos;

    public Line(Position startPos, Position endPos, Color color, int thickness) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.thickness = thickness;
        this.color = color;

    }

    public Position getEndPos() {
        return endPos;
    }

    public void setEndPos(Position endPos) {
        this.endPos = endPos;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startPos=" + startPos +
                "endPos=" + endPos +
                ", color='" + color + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
