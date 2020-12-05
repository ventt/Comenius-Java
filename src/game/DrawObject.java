package game;

//ős osztálya minden rajzobjektumnak
public class DrawObject {
    protected Position startPos;
    protected String colour;
    protected int thickness;
   // protected LocalTime creationTime;

    public void setStartPos(Position startPos) {
        this.startPos = startPos;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setThickness(int thickness) { this.thickness = thickness;}

    public Position getStartPos() {
        return startPos;
    }
    public String getColour() {
        return colour;
    }
    public int getThickness() { return thickness;}

    @Override
    public String toString() {
        return "DrawObject{" +
                "startPos=" + startPos +
                ", colour='" + colour + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
