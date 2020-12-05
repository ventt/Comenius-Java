package controller;

import game.commands.Command;
import model.CommandListModel;

import javax.swing.*;
import java.util.List;

public class ListController {
    private JList<Command> jList;


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
