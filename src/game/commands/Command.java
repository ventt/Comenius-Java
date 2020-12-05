package game.commands;

import game.Core;

public interface Command {
    void method(Core core);
    String toString();
}
