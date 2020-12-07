package game;

public class JdkElf {
    private final Position home = new Position(0, 0);
    private final Pen pen = new Pen();
    private Position current = home;
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
        return current;
    }

    //pozicio
    public void setCurrent(Position current) {
        this.current = current;
    }

    public void setHome() {
        current = home;
    }

    public void setElfDefault() {
        setHome();
        rotation = Rotation.FORWARD;
        pen.penSetDefault();
    }

    @Override
    public String toString() {
        return "JdkElf{" +
                "home=" + ((current.getX() == home.getX() && current.getY() == home.getY()) ? "yes" : "no") +
                ", current=" + current +
                ", orientation=" + rotation +
                ", pen=" + pen +
                '}';
    }
}
