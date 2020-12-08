package comeniusjava.game;

public enum Rotation {
    FORWARD(Math.PI * 0),
    RIGHT(Math.PI * 0.5),
    BACKWARD(Math.PI * 1),
    LEFT(Math.PI * 1.5);

    private final double theta;

    Rotation(double theta) {
        this.theta = theta;
    }

    public double getTheta() {
        return theta;
    }
}
