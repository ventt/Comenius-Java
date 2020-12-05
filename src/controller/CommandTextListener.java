package controller;

import game.Core;
import view.MyCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandTextListener implements ActionListener {
    private TextField t;
    private MyCanvas canvas;
    private CommandTranslator ct = new CommandTranslator();
    public CommandTextListener(TextField t, MyCanvas canvas){this.t = t; this.canvas = canvas;}
    @Override
    public void actionPerformed(ActionEvent e) {
        ct.translate(t.getText());
        t.setText("");
        canvas.repaint();
    }
}
