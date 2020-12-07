package comeniusjava.controller;


import comeniusjava.game.Core;
import comeniusjava.view.MyCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandTextListener implements ActionListener {
    private final TextField t;
    private final MyCanvas canvas;
    private final CommandTranslator ct = new CommandTranslator();
    private final ListController list;

    public CommandTextListener(TextField t, MyCanvas canvas, ListController list) {
        this.t = t;
        this.canvas = canvas;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ct.translate(t.getText());
            t.setText("");
            list.refresh(Core.getInstance().getCommands());
            canvas.repaint();
        } catch (Exception ex) {
            t.setText(ex.getMessage());
        }
    }
}
