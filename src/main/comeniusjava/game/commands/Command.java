package comeniusjava.game.commands;


import comeniusjava.game.Core;

import java.io.Serializable;

public interface Command extends Serializable {
    void apply(Core core);

    String toString();
}
