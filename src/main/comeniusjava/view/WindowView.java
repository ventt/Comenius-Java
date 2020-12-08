package comeniusjava.view;


import comeniusjava.game.Core;
import comeniusjava.game.commands.Command;
import comeniusjava.model.CommandListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.nio.file.Path;

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

        JMenuItem save = getSaveMenu();
        fileMenu.add(save);

        JMenuItem load = getLoadMenu();
        fileMenu.add(load);

        menubar.add(fileMenu);
        return menubar;
    }

    /**
     * @return
     */
    private JMenuItem getLoadMenu() {
        JMenuItem load = new JMenuItem("Load");
        JDialog loadDialog = new JDialog(frame, "Load save", true);

        loadDialog.setMinimumSize(new Dimension(600, 400));
        loadDialog.setVisible(false);

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(Path.of(".").toFile());
                fileChooser.setFileHidingEnabled(false);
                fileChooser.setSelectedFile(Path.of("save.txt").toFile());
                fileChooser.setApproveButtonText("Load");

                fileChooser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String actionCommand = e.getActionCommand();
                        switch (actionCommand) {
                            case "ApproveSelection":
                                try {
                                    String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                                    System.out.println("Load file " + absolutePath);
                                    Core.getInstance().load(absolutePath);
                                    Core.getInstance().doCommands();
                                    canvas.repaint();
                                    commandList.setModel(new CommandListModel(Core.getInstance().getCommands()));
                                    loadDialog.remove(fileChooser);
                                    loadDialog.setVisible(false);
                                } catch (IOException | ClassNotFoundException ioException) {
                                    ioException.printStackTrace();
                                    throw new RuntimeException(ioException);
                                }
                                break;
                            case "CancelSelection":
                                loadDialog.remove(fileChooser);
                                loadDialog.setVisible(false);
                                break;
                        }
                    }
                });
                loadDialog.add(fileChooser);
                loadDialog.setVisible(true);
            }
        });
        return load;
    }

    /**
     * @return
     */
    private JMenuItem getSaveMenu() {
        JMenuItem save = new JMenuItem("Save");
        JDialog saveDialog = new JDialog(frame, "Save", true);

        saveDialog.setMinimumSize(new Dimension(600, 400));
        saveDialog.setVisible(false);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(Path.of(".").toFile());
                fileChooser.setFileHidingEnabled(false);
                fileChooser.setSelectedFile(Path.of("save.txt").toFile());
                fileChooser.setApproveButtonText("Save");

                fileChooser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String actionCommand = e.getActionCommand();
                        switch (actionCommand) {
                            case "ApproveSelection":
                                try {
                                    String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                                    System.out.println("Save file to " + absolutePath);
                                    Core.getInstance().save(absolutePath);
                                    saveDialog.remove(fileChooser);
                                    saveDialog.setVisible(false);
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                    throw new RuntimeException(ioException);
                                }
                                break;
                            case "CancelSelection":
                                saveDialog.remove(fileChooser);
                                saveDialog.setVisible(false);
                                break;
                        }
                    }
                });
                saveDialog.add(fileChooser);
                saveDialog.setVisible(true);
            }
        });
        return save;
    }


}
