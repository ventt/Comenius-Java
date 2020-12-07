package comeniusjava.controller;


import comeniusjava.view.MyCanvas;

public class CanvasController {
    private final MyCanvas Canvas;
    public CanvasController(){
        Canvas = new MyCanvas();
    }
    public MyCanvas getCanvas() {
        return Canvas;
    }
}
