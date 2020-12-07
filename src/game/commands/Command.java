package game.commands;

import game.Core;

import java.io.Serializable;

public interface Command extends Serializable {
    void method(Core core);

    String toString();
}
