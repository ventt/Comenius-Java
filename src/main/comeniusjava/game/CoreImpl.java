package comeniusjava.game;


import comeniusjava.game.commands.Command;
import comeniusjava.game.draw.DrawObject;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

class CoreImpl extends Core {
    final ArrayList<Command> commands = new ArrayList<>();
    final JdkElf elf = new JdkElf();
    final ArrayList<DrawObject> draws = new ArrayList<>();
    private Color backGroundColor = Color.lightGray;

    CoreImpl() {
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
            command.apply();
            System.out.println(elf.toString());
        }
        System.out.println();
    }

    public void setDefault() {
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
