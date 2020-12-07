package game.color;

import java.awt.*;

public enum ApplicationColor {
    BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    CYAN(Color.CYAN),
    DARK_GRAY(Color.DARK_GRAY),
    GRAY(Color.GRAY),
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW),
    LIGHT_GRAY(Color.LIGHT_GRAY),
    MAGENTA(Color.MAGENTA),
    ORANGE(Color.ORANGE),
    PINK(Color.PINK),
    RED(Color.RED),
    WHITE(Color.WHITE);

    private final Color color;

    ApplicationColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static ApplicationColor getByColor(Color color) {
        for (ApplicationColor appColor : ApplicationColor.values()) {
            if (appColor.getColor().equals(color)) {
                return appColor;
            }
        }
        throw new IllegalArgumentException();
    }
}
