package comeniusjava.game.draw;


import comeniusjava.game.Position;

import java.awt.*;

/**
 * Kör adatait tároló osztály, a DrawObject leszármazottja.
 */
public class Circle extends DrawObject {
    private final int radius;

    /**
     * konstrukto.
     *
     * @param startPos  kezdőpozició, kör középpontja.
     * @param radius    sugár mérete.
     * @param color     a kör vonalának színe.
     * @param thickness a kör vonalának vastagsága.
     */
    public Circle(Position startPos, int radius, Color color, int thickness) {
        super(startPos, color, thickness);
        this.radius = radius;
    }

    /**
     * @return a sugár mérete.
     */
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
