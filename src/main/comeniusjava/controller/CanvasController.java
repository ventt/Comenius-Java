package comeniusjava.controller;


import comeniusjava.view.MyCanvas;

/**
 * Létrehozza és tárolja a canvast
 */
public class CanvasController {
    private final MyCanvas Canvas;

    /**
     * konstruktor.
     */
    public CanvasController() {
        Canvas = new MyCanvas();
    }

    /**
     * @return Canvas
     */
    public MyCanvas getCanvas() {
        return Canvas;
    }
}
