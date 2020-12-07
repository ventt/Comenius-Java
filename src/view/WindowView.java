package view;

import game.commands.Command;

import javax.swing.*;
import java.awt.*;

public class WindowView {
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu fileMenu;
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem help;
    private MyCanvas canvas;
    private JComboBox jComboBox;

    public TextField getCommmandPrompt() {
        return commmandPrompt;
    }


    private TextField commmandPrompt;
    private JList<Command> commandList;
    private JPanel canvasPanel;
    private TextField scaleText;
    private JPanel rightPanel;
    private JScrollPane canvasPanelScroll;
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
        canvasPanelScroll = new JScrollPane();
        canvasPanel = new JPanel();

        canvasPanel.setSize(new Dimension(1600,920));
        canvasPanel.setMinimumSize(new Dimension(800,800));
        //canvasPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));
        //canvasPanel.setAutoscrolls(true);
        canvas.setSize(canvasPanel.getSize());
        canvasPanel.add(canvas);

        //canvasPanel.add(canvasPanel, BorderLayout.CENTER);









        rightPanel = new JPanel();
        rightPanel.setMinimumSize(new Dimension(600, frame.getHeight()));
        commandList.setMinimumSize(rightPanel.getMinimumSize());
        rightPanel.add(commandList,BorderLayout.CENTER);


        frame.add(canvasPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.add(commmandPrompt, BorderLayout.SOUTH);
        frame.setPreferredSize(new Dimension(1920,1080));
        frame.pack();


        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
