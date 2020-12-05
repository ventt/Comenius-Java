package view;

import controller.CommandTranslator;
import game.Core;

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
    private JList<String> commandList;
    private JPanel canvasPanel;
    private TextField scaleText;
    private JPanel leftPanel;
    public WindowView(MyCanvas canvas){
        this.canvas = canvas;
        commandList = new JList(Core.getInstance().getCommandsListString().toArray());
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

        canvasPanel.setSize(new Dimension(800,800));
        canvasPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        canvas.setSize(canvasPanel.getSize());
        canvasPanel.add(canvas);
        canvas.setBackground(Color.LIGHT_GRAY);

        leftPanel = new JPanel();




        leftPanel.add(commandList);


        frame.add(canvasPanel, BorderLayout.WEST);
        frame.add(leftPanel, BorderLayout.EAST);
        frame.add(commmandPrompt, BorderLayout.SOUTH);
        frame.pack();
        frame.setMaximumSize(new Dimension(1920,1080));

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
