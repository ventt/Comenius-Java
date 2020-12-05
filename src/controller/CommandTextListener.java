package controller;

import game.Core;
import view.MyCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandTextListener implements ActionListener {
    private TextField t;
    private MyCanvas canvas;
    private CommandTranslator ct = new CommandTranslator();
    private ListController list;
    public CommandTextListener(TextField t, MyCanvas canvas, ListController list){this.t = t; this.canvas = canvas; this.list = list;}
    @Override
    public void actionPerformed(ActionEvent e) {
        ct.translate(t.getText());
        t.setText("");
        list.refresh(Core.getInstance().getCommands());
        canvas.repaint();
    }
}
