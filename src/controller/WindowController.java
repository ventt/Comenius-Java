package controller;

import view.WindowView;

public class WindowController  {

    private WindowView windowView;
    private CanvasController canvasController;
    private CommandTextListener commandTextListener;
    private ListController listController;
    public WindowController() {
        canvasController = new CanvasController();
        listController = new ListController();
        windowView = new WindowView(canvasController.getCanvas(), listController.getjList());
        windowView.createWindow();

        commandTextListener = new CommandTextListener(windowView.getCommmandPrompt(), canvasController.getCanvas(),listController);
        windowView.getCommmandPrompt().addActionListener(commandTextListener);

    }

}
