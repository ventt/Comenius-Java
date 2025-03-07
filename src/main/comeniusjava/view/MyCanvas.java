package comeniusjava.view;


import comeniusjava.game.Core;
import comeniusjava.game.draw.Circle;
import comeniusjava.game.draw.DrawObject;
import comeniusjava.game.draw.Line;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Grafika megjelenítésért felelős osztály, Canvas leszármazottja, nagyítást tartalmaz a szebb megjelenítésért.
 */
public class MyCanvas extends Canvas {
    private int scale = 10;

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
        repaint();
    }

    /**
     * Canvas ős osztály paint metódusának felül írása
     *
     * @param g grafika
     */
    @Override
    public void paint(Graphics g) {
        setBackground(Core.getInstance().getBackGroundColor());
        Core core = Core.getInstance();
        Graphics2D g2 = (Graphics2D) g;

        try {
            drawElf(g2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (DrawObject draw : core.getDraws()) {
            g2.setColor(draw.getColor()); //egyelőre
            g2.setStroke(new BasicStroke(draw.getThickness()));

            if (draw instanceof Line) {
                Line line = (Line) draw;
                g2.draw(new Line2D.Double(
                        draw.getStartPos().toPoint(this),
                        line.getEndPos().toPoint(this)
                ));
            } else if (draw instanceof Circle) {
                Circle circle = (Circle) draw;
                Point2D point = draw.getStartPos().toPoint(this);
                g2.draw(new Ellipse2D.Double(
                        point.getX() - (double) circle.getRadius() * scale / 2.0,
                        point.getY() - (double) circle.getRadius() * scale / 2.0,
                        circle.getRadius() * scale,
                        circle.getRadius() * scale
                ));
            }

        }
    }

    /**
     * JdkElf és a Pen kirajzolását és tarnfromálását végrehajtó metódus
     *
     * @param g2 Graphics2D
     * @throws IOException
     */
    private void drawElf(Graphics2D g2) throws IOException {
        BufferedImage elfImg = ImageIO.read(ClassLoader.getSystemResource("resource/JdkElfImage.png"));
        BufferedImage pencilImg = ImageIO.read(ClassLoader.getSystemResource("resource/pencil.png"));

        Point2D c = Core.getInstance().getElf().getPosition().toPoint(this);

        // Center
        g2.setColor(Core.getInstance().getElf().getPen().getColor());
        final int radius = Core.getInstance().getElf().getPen().getPenThickness();
        g2.drawOval((int) c.getX() - radius / 2, (int) c.getY() - radius / 2, radius, radius);
        g2.fillOval((int) c.getX() - radius / 2, (int) c.getY() - radius / 2, radius, radius);

        {
            AffineTransform affineTransform = AffineTransform.getTranslateInstance(c.getX() - 20, c.getY() - 35);

            affineTransform.scale(0.5, 0.5);

            g2.drawImage(elfImg, affineTransform, this);
        }
        {
            AffineTransform affineTransform = AffineTransform.getTranslateInstance(c.getX() - 3, Core.getInstance().getElf().getPen().isDrawing() ? c.getY() - 42 : c.getY() - 50);

            affineTransform.scale(0.05, 0.05);
            g2.drawImage(pencilImg, affineTransform, this);
        }

    }
}
