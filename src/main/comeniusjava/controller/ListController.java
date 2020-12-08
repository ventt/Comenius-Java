package comeniusjava.controller;


import comeniusjava.game.commands.Command;
import comeniusjava.model.CommandListModel;

import javax.swing.*;
import java.util.List;

/**
 * Model megvalósítás a swing Jlist számára
 */
public class ListController {
    private final JList<Command> jList;

    /**
     * Konstruktor
     */
    public ListController() {
        jList = new JList<>();
    }

    /**
     * visszaadja a Jlist-et
     *
     * @return Jlist
     */
    public JList<Command> getjList() {
        return jList;
    }

    /**
     * Frissití a Jlist tartalmát
     *
     * @param commands List<Command>
     */
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
