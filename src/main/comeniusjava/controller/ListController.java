package comeniusjava.controller;


import comeniusjava.game.commands.Command;
import comeniusjava.model.CommandListModel;

import javax.swing.*;
import java.util.List;

public class ListController {
    private final JList<Command> jList;


    public JList<Command> getjList() {
        return jList;
    }

    public ListController() {
        jList = new JList<>();
    }

    void refresh(List<Command> commands) {
        CommandListModel commandListModel = new CommandListModel(commands);
        jList.setModel(commandListModel);
    }

}
