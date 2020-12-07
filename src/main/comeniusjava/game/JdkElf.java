package comeniusjava.game;

public class JdkElf {
    private final Position home = new Position(0, 0);
    private final Pen pen = new Pen();
    private Position position = home;
    private Rotation rotation = Rotation.FORWARD;

    JdkElf() {
    }

    public Pen getPen() {
        return pen;
    }

    public Rotation getOrientation() {
        return rotation;
    }

    //irány
    public void setOrientation(Rotation rotation) {
        this.rotation = rotation;
    }

    public Position getPosition() {
        return position;
    }

    //pozicio
    public void setPosition(Position current) {
        this.position = current;
    }

    public void setHome() {
        position = home;
    }

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
