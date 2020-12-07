package comeniusjava.game;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void toPoint_center() {
        Point2D point2D = new Position(0, 0).toPoint(100, 100, 2);
        assertEquals(50.0, point2D.getX(), 0.1);
        assertEquals(50.0, point2D.getY(), 0.1);
    }

    @Test
    public void toPoint_edge() {
        Point2D point2D = new Position(25, 25).toPoint(100, 100, 2);
        assertEquals(100.0, point2D.getX(), 0.1);
        assertEquals(0.0, point2D.getY(), 0.1);
    }
}