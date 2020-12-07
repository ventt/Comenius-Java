package comeniusjava.view;


import comeniusjava.game.Core;
import comeniusjava.game.Position;
import comeniusjava.game.draw.Circle;
import comeniusjava.game.draw.DrawObject;
import comeniusjava.game.draw.Line;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MyCanvas extends Canvas {
    private int scale = 10;

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
        repaint();
    }

    public Position ConvertImagePosition(Position p, int canvasWidth, int canvasHeight) {
        return new Position(scale * p.getX() + canvasWidth / 2, canvasHeight / 2 - scale * p.getY());
    }

    @Override
    public void paint(Graphics g) {
        setBackground(Core.getInstance().getBackGroundColor());
        Core core = Core.getInstance();
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage imgElf = null;
        try {
            URL imageUrl = ClassLoader.getSystemResource("resource/JdkElfImage.png");
            imgElf = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(imgElf, ConvertImagePosition(Core.getInstance().getElf().getPosition(), this.getWidth(), this.getHeight()).getX(), ConvertImagePosition(Core.getInstance().getElf().getPosition(), this.getWidth(), this.getHeight()).getY(), this);


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
}
