package game;

public class Line extends DrawObject {

    private Position endPos;

    public Line(Position startPos, Position endPos, String colour, int thickness ){
        this.startPos = startPos;
        this.endPos = endPos;
        this.thickness = thickness;
        this.colour = colour;
        //this.creationTime = new LocalTime();
    }
    public Line(){}

    public void setEndPos(Position endPos) {
        this.endPos = endPos;
    }

    public Position getEndPos() {
        return endPos;
    }


    @Override
    public String toString() {
        return "Line{" +
                "startPos=" + startPos +
                "endPos=" + endPos +
                ", colour='" + colour + '\'' +
                ", thickness=" + thickness +
                '}';
    }
}
