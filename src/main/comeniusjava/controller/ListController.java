package comeniusjava.controller;


import comeniusjava.game.commands.Command;
import comeniusjava.model.CommandListModel;

import javax.swing.*;
import java.util.List;

public class ListController {
    private final JList<Command> jList;

    public ListController() {
        jList = new JList<>();
    }

    public JList<Command> getjList() {
        return jList;
    }

    void refresh(List<Command> commands) {
        if (commands.size() == 0) {
            jList.setModel(new AbstractListModel<>() {
                @Override
                public int getSize() {
                    return 1;
                }

                @Override
                public Command getElementAt(int index) {
                    return new Command() {

                        @Override
                        public void apply() {

                        }

                        @Override
                        public String toString() {
                            return "";
                        }
                    };
                }
            });
        } else {
            jList.setModel(new CommandListModel(commands));
        }
    }

}
