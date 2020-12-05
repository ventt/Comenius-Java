package game;

public class Pen {
    //singleton
    private static final Pen instance = new Pen();

    private Pen() {}

    private boolean isDrawing = false;
    private String colour = "Black";
    private int penThickness = 1;

    public static Pen getInstance() {
        return instance;
    }


    public boolean isDrawing() {
        return isDrawing;
    }

    public void setDrawing(boolean drawing) {
        isDrawing = drawing;
    }

    public void setColour(String colour){
        this.colour = colour;
    }
    public void setPenThickness(int penThickness){
        this.penThickness = penThickness;
    }

    public String getColour() {
        return colour;
    }



    public int getPenThickness() {
        return penThickness;
    }
    public void penSetDefault(){
        isDrawing = false;
        colour = "Black";
        penThickness = 1;
    }
    @Override
    public String toString() {
        return "Pen{" +
                "upDown=" + isDrawing +
                ", colour='" + colour + '\'' +
                ", penThickness=" + penThickness +
                '}';
    }
}
