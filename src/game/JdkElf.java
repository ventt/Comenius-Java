package game;

public class JdkElf {
    private static final JdkElf instance = new JdkElf();
    private JdkElf(){}
    private Position home = new Position(0,0);
    private Position current = home;
    private Orientation orientation = Orientation.NORTH;
    private Pen pen = Pen.getInstance();
    public static JdkElf getInstance() {
        return instance;
    }
    public Pen getPen() {
        return pen;
    }
    //irány
    public void setOrientation(Orientation orientation) { this.orientation = orientation;}
    public Orientation getOrientation() { return orientation; }
    //pozicio
    public void setCurrent(Position current) { this.current = current;}
    public Position getCurrent() { return current; }
    public void setHome(){
        current = home;
    }
    public void setElfDefault(){
        setHome();
        orientation = Orientation.NORTH;
        pen.penSetDefault();
    }
    @Override
    public String toString() {
        return "JdkElf{" +
                "home=" + ((current.getX() == home.getX() && current.getY() == home.getY()) ? "yes" : "no") +
                ", current=" + current +
                ", orientation=" + orientation +
                ", pen=" + pen +
                '}';
    }
}
