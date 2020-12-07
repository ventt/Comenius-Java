package comeniusjava.game.commands;


import java.io.Serializable;

public interface Command extends Serializable {
    void apply();

    String toString();
}
