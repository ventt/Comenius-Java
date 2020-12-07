package game;

import model.MyColor;

import java.awt.*;

public class Pen {
    //singleton
    private static final Pen instance = new Pen();

    private Pen() {}

    private boolean isDrawing = false;
    private MyColor colour = new MyColor(Color.black);
    private int penThickness = 1;

    public static Pen getInstance() {
        return instance;
    }


    public boolean isDrawing() {
        return isDrawing;
    }

    public void setDrawing(boolean drawing) {
        isDrawing = drawing;
    }

    public void setColour(MyColor colour){
        this.colour = colour;
    }
    public void setPenThickness(int penThickness){
        this.penThickness = penThickness;
    }

    public MyColor getColour() {
        return colour;
    }



    public int getPenThickness() {
        return penThickness;
    }
    public void penSetDefault(){
        isDrawing = false;
        colour = new MyColor(Color.BLACK);
        penThickness = 1;
    }
    @Override
    public String toString() {
        return "Pen{" +
                "upDown=" + isDrawing +
                ", colour='" + colour + '\'' +
                ", penThickness=" + penThickness +
                '}';
    }
}
