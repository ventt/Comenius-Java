package game.color;

public class ColorNotFoundException extends Exception {
    public ColorNotFoundException(String colorName) {
        super(colorName + " color was not found");
    }
}
