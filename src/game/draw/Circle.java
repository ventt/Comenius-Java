package game.draw;

import game.Position;

import java.awt.*;

public class Circle extends DrawObject {
    private final int radius;

    public Circle(Position startPos, int radius, Color color, int thickness) {
        super(startPos, color, thickness);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "startPos=" + startPos +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
