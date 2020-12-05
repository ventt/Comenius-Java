package controller;

import view.WindowView;

public class WindowController  {

    private WindowView windowView;
    private CanvasController canvasController;
    private CommandTextListener commandTextListener;
    public WindowController() {
        canvasController = new CanvasController();
        windowView = new WindowView(canvasController.getCanvas());
        windowView.createWindow();

        commandTextListener = new CommandTextListener(windowView.getCommmandPrompt(), canvasController.getCanvas());
        windowView.getCommmandPrompt().addActionListener(commandTextListener);

    }

}
