package comeniusjava.game;


import comeniusjava.game.commands.Command;
import comeniusjava.game.draw.DrawObject;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Core egy szingleton osztály, tartalmazza a JdkElf elf-et, a commands: parancsok listáját, a draws: alakzatok listáját és a backGroundColor: háttérszínt.
 */
public class Core {
    private static Core instance = null;
    final ArrayList<Command> commands = new ArrayList<>();
    final JdkElf elf = new JdkElf();
    final ArrayList<DrawObject> draws = new ArrayList<>();
    private Color backGroundColor = Color.lightGray;

    /**
     * private konstruktor.
     */
    private Core() {
    }

    /**
     * Visszaadja a Core instance-t.
     *
     * @return a Core elérését
     */
    public static Core getInstance() {
        if (instance == null) {
            instance = new Core();
        }
        return instance;
    }

    /**
     * Vissza adja a Core által tárolt elf-et.
     *
     * @return JdkElf: a JdkElf osztály elérését
     */
    public JdkElf getElf() {
        return elf;
    }

    /**
     * Visszaadja a Core által tárolt command listát.
     *
     * @return ArrayList<Command>: a Command-okat tartalmazó listát
     */
    public ArrayList<Command> getCommands() {
        return commands;
    }

    /**
     * Visszaadja a alakzat objektumokat tároló listát.
     *
     * @return Arraylis<DrawObject> DrawObject-eket tartalmazó listát
     */
    public ArrayList<DrawObject> getDraws() {
        return draws;
    }

    /**
     * letisztitja az adatokat a Core-ról.
     */
    public void clear() {
        backGroundColor = Color.lightGray;
        setDefault();
        draws.clear();
        commands.clear();
    }

    /**
     * Végig megy a commands listán és minden commandon meghívja az apply() fgv.-t.
     */
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

    /**
     * Vissza adja a háttér színét.
     *
     * @return Color backGroundColor: a háttér színét.
     */
    public Color getBackGroundColor() {
        return backGroundColor;
    }

    /**
     * Beállítja a háttér színét
     *
     * @param backGroundColor: paraméterként megadott Color színt állítja be háttérként.
     */
    public void setBackGroundColor(Color backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    /**
     * A commands listából szérializálja a megadott file-ba command osztályokat.
     *
     * @param file: String file, a fájlt adja át amibe menteni szeretnénk
     * @throws IOException
     */
    public void save(String file) throws IOException {
        try (FileOutputStream f = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(f)) {
            out.writeObject(commands);
        }
    }

    /**
     * Betölti a file-ba szérializált command osztályok listáját a commands listába.
     *
     * @param file: String file, a fájlt adja át amibe menteni szeretnénk
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void load(String file) throws IOException, ClassNotFoundException {
        try (FileInputStream f = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(f)) {
            commands.clear();
            commands.addAll((ArrayList<Command>) in.readObject());
        }
    }
}
