package view;

import game.Core;
import game.Line;
import game.Position;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyCanvas extends Canvas {
    private int scale = 10;

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
        repaint();
    }

    public Position convertPosition(Position p, int canvasWidth, int canvasHeight) {
        return new Position(scale * p.getX() + canvasWidth / 2, canvasHeight / 2 - scale * p.getY());
    }

    @Override
    public void paint(Graphics g) {
        setBackground(Core.getInstance().getBackGroundColor());
        Core core = Core.getInstance();
        ArrayList<game.Line> list;
        list = (ArrayList<Line>) core.getList();
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage imgElf = null;
        try {
            imgElf = ImageIO.read(new File("res", "JdkElfImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(imgElf, convertPosition(Core.getInstance().getElf().getCurrent(), this.getWidth(), this.getHeight()).getX(), convertPosition(Core.getInstance().getElf().getCurrent(), this.getWidth(), this.getHeight()).getY(), this);


        for (Line line : list) {
            g2.setColor(line.getColor()); //egyelőre
            g2.setStroke(new BasicStroke(line.getThickness()));
            g2.draw(new Line2D.Double(convertPosition(line.getStartPos(), this.getWidth(), this.getHeight()).getX(),
                    convertPosition(line.getStartPos(), this.getWidth(), this.getHeight()).getY(),
                    convertPosition(line.getEndPos(), this.getWidth(), this.getHeight()).getX(),
                    convertPosition(line.getEndPos(), this.getWidth(), this.getHeight()).getY()));
        }
    }
}
