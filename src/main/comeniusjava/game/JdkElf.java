package comeniusjava.game;

/**
 * A manó adatait tároló osztály, a hozzá tartozó metódusokat megvalósítását tartalmazza.
 */
public class JdkElf {
    private final Position home = new Position(0, 0);
    private final Pen pen = new Pen();
    private Position position = home;
    private Rotation rotation = Rotation.FORWARD;

    /**
     * Csak a package által látható konstruktor
     */
    JdkElf() {
    }

    /**
     * @return pen: az osztály által tárolt toll osztályt.
     */
    public Pen getPen() {
        return pen;
    }

    /**
     * @return rotation: az osztály által tárolt irányt.
     */
    public Rotation getOrientation() {
        return rotation;
    }

    /**
     * @param rotation-re átállítja az osztály által tárolt irányt.
     */
    public void setOrientation(Rotation rotation) {
        this.rotation = rotation;
    }

    /**
     * A JdkElf pályán lévő pozicióját.
     *
     * @return az osztály által tárolt poziciót.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param current-re állítja az osztály által tárolt irányt.
     */
    public void setPosition(Position current) {
        this.position = current;
    }

    /**
     * Visszaállítja a poziciót a Position(0.0,0.0)-ba, haza.
     */
    public void setHome() {
        position = home;
    }

    /**
     * Visszaállítja az eredeti értékeit az osztálynak.
     */
    public void setElfDefault() {
        setHome();
        rotation = Rotation.FORWARD;
        pen.penSetDefault();
    }

    @Override
    public String toString() {
        return "JdkElf{" +
                "home=" + ((position.getX() == home.getX() && position.getY() == home.getY()) ? "yes" : "no") +
                ", current=" + position +
                ", orientation=" + rotation +
                ", pen=" + pen +
                '}';
    }
}
