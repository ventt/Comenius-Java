package comeniusjava.view;


import comeniusjava.game.Core;
import comeniusjava.game.commands.Command;
import comeniusjava.model.CommandListModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
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
        fileMenu.add(getSaveMenu());
        fileMenu.add(getLoadMenu());
        menubar.add(fileMenu);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(getCommandsMenu());
        helpMenu.add(getAboutMenu());
        menubar.add(helpMenu);

        return menubar;
    }

    private JMenuItem getAboutMenu() {
        JMenuItem aboutMenu = new JMenuItem("About");

        JDialog aboutDialog = new JDialog(frame, "Help / About", true);
        aboutDialog.setVisible(false);

        try {
            BufferedImage image = ImageIO.read(ClassLoader.getSystemResource("resource/about.png"));
            aboutDialog.add(new JLabel(new ImageIcon(image)));
            aboutDialog.setSize(image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        aboutMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutDialog.setVisible(true);
            }
        });

        return aboutMenu;
    }

    private JMenuItem getCommandsMenu() {
        JMenuItem commandsMenu = new JMenuItem("Commands");

        JDialog commandsDialog = new JDialog(frame, "Help / Commands", false);
        commandsDialog.setVisible(false);

        JList<String> commandList = new JList<>(new String[]{
                "Available commands:",
                "load <file>",
                "save <file>",
                "move <steps>",
                "pen up|down|thickness [brush size]",
                "rotate forward|right|backward|left",
                "color <pen color>",
                "background <background color>",
                "circle <circle radius>",
                "home",
                "undo",
                "clear"
        });

        commandsDialog.add(commandList);
        commandsDialog.setSize(350, 300);

        commandsMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandsDialog.setVisible(true);
            }
        });

        return commandsMenu;
    }

    /**
     * @return
     */
    private JMenuItem getLoadMenu() {
        JMenuItem load = new JMenuItem("Load");
        JDialog loadDialog = new JDialog(frame, "File / Load", true);

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
        JDialog saveDialog = new JDialog(frame, "File / Save", true);

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
