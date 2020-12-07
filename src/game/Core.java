package game;

import game.commands.Command;
import game.draw.DrawObject;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Core {
    private static final Core instance = new Core();
    final ArrayList<Command> commands = new ArrayList<>();
    final JdkElf elf = new JdkElf();
    final ArrayList<DrawObject> draws = new ArrayList<>();
    private Color backGroundColor = Color.lightGray;

    private Core() {
    }

    public static Core getInstance() {
        return instance;
    }

    public JdkElf getElf() {
        return elf;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public ArrayList<DrawObject> getDraws() {
        return draws;
    }

    public void clear() {
        backGroundColor = Color.lightGray;
        setDefault();
        draws.clear();
        commands.clear();
    }

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

    public Color getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(Color backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public void save(String file) throws IOException {
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(f);
        out.writeObject(commands);
        out.close();
    }

    public void load(String file) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(f);
        commands.clear();
        commands.addAll((ArrayList<Command>) in.readObject());
    }
}
