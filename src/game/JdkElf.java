package game;

public class JdkElf {
    private static final JdkElf instance = new JdkElf();
    private final Position home = new Position(0, 0);
    private Position current = home;
    private final Pen pen = Pen.getInstance();
    private Rotation rotation = Rotation.FORWARD;

    private JdkElf() {
    }

    public static JdkElf getInstance() {
        return instance;
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

    public Position getCurrent() {
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
