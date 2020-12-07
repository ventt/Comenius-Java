package comeniusjava.game.commands;


import java.io.Serializable;

/**
 * A parancsok Interface-e.
 */
public interface Command extends Serializable {
    /**
     * Minden impelementációban megvalósítandó, parancs feladatát végrehajtó metódus.
     */
    void apply();

    /**
     * @return Minden impelementációban megvalósítandó, parancs adatait Stringbe kiíró metódus.
     */
    String toString();
}
