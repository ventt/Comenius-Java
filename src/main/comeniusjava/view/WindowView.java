package comeniusjava.view;


import comeniusjava.game.commands.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class WindowView {
    private final MyCanvas canvas;
    private final JList<Command> commandList;
    private TextField commandTextField;
    private JPanel canvasPanel;
    private JFrame frame;
    public ComponentListener canvasResizeComponentListener = new ComponentListener() {
        @Override
        public void componentResized(ComponentEvent e) {
            canvas.setSize(canvasPanel.getSize());
            frame.repaint();
        }

        @Override
        public void componentMoved(ComponentEvent e) {
        }

        @Override
        public void componentShown(ComponentEvent e) {
        }

        @Override
        public void componentHidden(ComponentEvent e) {
        }
    };


    public WindowView(MyCanvas canvas, JList<Command> commandList) {
        this.canvas = canvas;
        this.commandList = commandList;
    }

    public TextField getCommandTextField() {
        return commandTextField;
    }


    public void createWindow() {
        frame = new JFrame("Comenius Java");
        frame.setJMenuBar(getMenuBar());
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(800, 600));

        // Canvas CENTER
        canvasPanel = new JPanel();
        canvasPanel.add(canvas);
        frame.getContentPane().add(canvasPanel, BorderLayout.CENTER);
        canvasPanel.addComponentListener(canvasResizeComponentListener);

        // Right panel LINE_END
        commandList.setFixedCellWidth(200);
        frame.getContentPane().add(commandList, BorderLayout.LINE_END);

        // Command Text Field PAGE_END
        commandTextField = new TextField("Várom parancsait!");
        frame.getContentPane().add(commandTextField, BorderLayout.PAGE_END);

        frame.addComponentListener(canvasResizeComponentListener);
        frame.pack();
        canvas.setSize(canvasPanel.getSize());

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private JMenuBar getMenuBar() {
        JMenuBar menubar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        fileMenu.add(save);
        fileMenu.add(load);
        menubar.add(fileMenu);
        return menubar;
    }


}
