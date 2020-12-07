package game;

import game.commands.Command;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Core {
    private static final Core instance = new Core();
    JdkElf elf = JdkElf.getInstance();
    ArrayList<Command> commands = new ArrayList<Command>();
    ArrayList<Line> draws = new ArrayList<Line>();
    private Color backGroundColor = Color.lightGray;

    public static Core getInstance() {
        return instance;
    }

    public JdkElf getElf() {
        return elf;
    }

    //Minden listával kapcsolatos metodus
    public void addCommands(Command command) {
        commands.add(command);
    }

    public void addDraws(Line draw) {
        draws.add(draw);
    }

    public void clearDraws() {
        draws.clear();
    }

    public List<Line> getList() {
        return draws;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public List<String> getCommandsListString() {
        List<String> out = new ArrayList<>();
        for (Command command : commands) {
            out.add(command.toString());
        }
        return out;
    }

    public void undo() { //Ezen még gondolkozni kell ;)
        commands.remove(commands.size() - 2);
        commands.remove(commands.size() - 1);
    }

    public void clear() {
        backGroundColor = Color.lightGray;
        setDefault();
        draws.clear();
        commands = new ArrayList<Command>();

    }

    public void clearBackground() {
        backGroundColor = Color.lightGray;
    }

    // Commands
    public void doCommands() {
        setDefault();
        for (Command command : commands) {
            command.method(this);
            System.out.println(elf.toString());
        }
        System.out.println();
    }

    private void setDefault() {
        elf.setElfDefault();
        draws.clear();
    }

    public String doCommandsString() {
        String out = "";
        System.out.println(elf.toString());
        for (int i = 0; i < commands.size(); i++) {
            commands.get(i).method(this);
            out.concat(elf.toString());
        }
        return out;
    }

    public void showDrawnObjects() {
        for (int i = 0; i < draws.size(); i++) {
            System.out.println(draws.get(i).toString());
        }
    }

    public Color getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(Color backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public void save(String file) {
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(commands);
            //out.writeObject(backGroundColor);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String file) {
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(f);
            commands = (ArrayList<Command>) in.readObject();
            //backGroundColor = (MyColor) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
