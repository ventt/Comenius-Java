package view;

import controller.CommandTranslator;
import game.Core;
import game.commands.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowView {
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu fileMenu;
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem help;
    private MyCanvas canvas;

    public TextField getCommmandPrompt() {
        return commmandPrompt;
    }


    private TextField commmandPrompt;
    private JList<Command> commandList;
    private JPanel canvasPanel;
    private TextField scaleText;
    private JPanel leftPanel;
    public WindowView(MyCanvas canvas, JList<Command> commandList){
        this.canvas = canvas;
        this.commandList = commandList;
    }

    public void createWindow(){
        frame =  new JFrame("Comenius Java");
        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
        fileMenu.add(save);
        fileMenu.add(load);
        menubar.add(fileMenu);

        commmandPrompt = new TextField("Várom parancsait!");
        frame.setJMenuBar(menubar);

        canvasPanel = new JPanel();

        canvasPanel.setSize(new Dimension(1600,920));
        canvasPanel.setMaximumSize(new Dimension(1600,960));
        canvasPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        canvasPanel.setAutoscrolls(true);
        canvas.setSize(canvasPanel.getSize());
        canvasPanel.add(canvas, BorderLayout.CENTER);
        canvas.setBackground(Color.LIGHT_GRAY);

        leftPanel = new JPanel();
        leftPanel.setSize(new Dimension(600, frame.getHeight()));
        leftPanel.add(commandList,BorderLayout.CENTER);


        frame.add(canvasPanel, BorderLayout.WEST);
        frame.add(leftPanel, BorderLayout.EAST);

        frame.add(commmandPrompt, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(1920,1080));
        frame.pack();


        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
