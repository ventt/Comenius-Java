package controller;

import view.MyCanvas;

import java.awt.*;

public class CanvasController {
    private final MyCanvas Canvas;
    public CanvasController(){
        Canvas = new MyCanvas();
    }

    public MyCanvas getCanvas() {
        return Canvas;
    }
}
