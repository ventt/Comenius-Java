package game.draw;

import game.Position;

import java.awt.*;

public class Line extends DrawObject {
    private final Position endPos;

    public Line(Position startPos, Position endPos, Color color, int thickness) {
        super(startPos, color, thickness);
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
                ", color='" + color + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
