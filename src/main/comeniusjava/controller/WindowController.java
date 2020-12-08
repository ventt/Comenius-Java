package comeniusjava.controller;


import comeniusjava.view.WindowView;

import java.util.List;

/**
 * Létrehozza és tárolja a Window-t és elementjeit
 */
public class WindowController {

    private final WindowView windowView;
    private final CanvasController canvasController;
    private final CommandTextListener commandTextListener;
    private final ListController listController;

    /**
     * Konstruktor
     */
    public WindowController() {
        canvasController = new CanvasController();
        listController = new ListController();
        windowView = new WindowView(canvasController.getCanvas(), listController.getjList());
        windowView.createWindow();

        commandTextListener = new CommandTextListener(windowView.getCommandTextField(), canvasController.getCanvas(), listController);
        windowView.getCommandTextField().addActionListener(commandTextListener);

        listController.refresh(List.of());
    }

}
