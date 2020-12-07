package comeniusjava.controller.commands;


import comeniusjava.game.commands.Command;

public interface CommandFactory<T extends Command> {
    /**
     * Letrehoz egy {@link Command} implementaciot a bevitt parancs szoveg alapjan
     *
     * @param input parancs szoveg
     * @return egy {@link Command} vagy <b>null</b>
     * @throws Exception ha nem megfelelo a bevitt parancs
     */
    T createFromText(String input) throws Exception;
}
