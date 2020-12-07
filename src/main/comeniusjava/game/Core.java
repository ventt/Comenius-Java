package comeniusjava.game;

import comeniusjava.game.commands.Command;
import comeniusjava.game.draw.DrawObject;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Core {
    private static final Core instance = new CoreImpl();

    public static Core getInstance() {
        return instance;
    }

    public abstract JdkElf getElf();

    public abstract ArrayList<Command> getCommands();

    public abstract ArrayList<DrawObject> getDraws();

    public abstract void clear();

    public abstract void doCommands();

    public abstract void setDefault();

    public abstract Color getBackGroundColor();

    public abstract void setBackGroundColor(Color backGroundColor);

    public abstract void save(String file) throws IOException;

    public abstract void load(String file) throws IOException, ClassNotFoundException;
}
