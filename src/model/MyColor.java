package model;

import java.awt.*;
import java.io.InvalidClassException;
import java.io.Serializable;

public class MyColor implements Serializable {
    private Color color;
        public MyColor(){}
        public MyColor(Color color){
            this.color = color;
        }
        public Color getColor(){
            return color;
        }
        public void setColor(String col) {
            switch (col.toLowerCase()) {
                case "black":
                    color = Color.BLACK;
                    break;
                case "blue":
                    color = Color.BLUE;
                    break;
                case "cyan":
                    color = Color.CYAN;
                    break;
                case "darkgray":
                    color = Color.DARK_GRAY;
                    break;
                case "gray":
                    color = Color.GRAY;
                    break;
                case "green":
                    color = Color.GREEN;
                    break;
                case "yellow":
                    color = Color.YELLOW;
                    break;
                case "lightgray":
                    color = Color.LIGHT_GRAY;
                    break;
                case "magneta":
                    color = Color.MAGENTA;
                    break;
                case "orange":
                    color = Color.ORANGE;
                    break;
                case "pink":
                    color = Color.PINK;
                    break;
                case "red":
                    color = Color.RED;
                    break;
                case "white":
                    color = Color.WHITE;
                    break;
                default:
                    new InvalidClassException("Invalid color");
                    //color = Color.BLACK;
                    break;
            }
        }
    public String getColorString(Color color) {
            String out = "error";
        if (Color.BLACK.equals(color)) {
            out = "black";
        } else if (Color.BLUE.equals(color)) {
            out = "blue";
        } else if (Color.CYAN.equals(color)) {
            out = "cyan";
        } else if (Color.DARK_GRAY.equals(color)) {
            out = "darkgray";
        } else if (Color.GRAY.equals(color)) {
            out = "gray";
        } else if (Color.GREEN.equals(color)) {
            out = "green";
        } else if (Color.YELLOW.equals(color)) {
            out = "yellow";
        } else if (Color.LIGHT_GRAY.equals(color)) {
            out = "lightgray";
        } else if (Color.MAGENTA.equals(color)) {
            out = "magenta";
        } else if (Color.ORANGE.equals(color)) {
            out = "orange";
        } else if (Color.PINK.equals(color)) {
            out = "pink";
        } else if (Color.RED.equals(color)) {
            out = "red";
        } else if (Color.WHITE.equals(color)) {
            out = "white";
        } /*else {
            //throw new IllegalStateException("Unexpected value: " + color);
        }*/
        return out;
    }

    @Override
    public String toString() {
        return "Color: "+this.getColorString(color);
    }
}
