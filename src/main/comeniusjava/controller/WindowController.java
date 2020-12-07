package comeniusjava.controller;


import comeniusjava.view.WindowView;

public class WindowController {

    private final WindowView windowView;
    private final CanvasController canvasController;
    private final CommandTextListener commandTextListener;
    private final ListController listController;

    public WindowController() {
        canvasController = new CanvasController();
        listController = new ListController();
        windowView = new WindowView(canvasController.getCanvas(), listController.getjList());
        windowView.createWindow();

        commandTextListener = new CommandTextListener(windowView.getCommmandPrompt(), canvasController.getCanvas(), listController);
        windowView.getCommmandPrompt().addActionListener(commandTextListener);

    }

}
