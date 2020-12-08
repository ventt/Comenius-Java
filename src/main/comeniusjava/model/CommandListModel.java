package comeniusjava.model;


import comeniusjava.game.commands.Command;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

/**
 * Jlist modell
 */
public class CommandListModel extends AbstractListModel<Command> {
    private final List<Command> commandList;

    public CommandListModel(List<Command> commandList) {
        this.commandList = Collections.unmodifiableList(commandList);
    }

    @Override
    public int getSize() {
        return commandList.size();
    }

    @Override
    public Command getElementAt(int index) {
        return commandList.get(index);
    }
}
