package game.color;

import java.awt.*;

public class ColorHelper {
    public static Color getColorFromString(String colorName) throws ColorNotFoundException {
        try {
            return ApplicationColor.valueOf(colorName).getColor();
        } catch (IllegalArgumentException e) {
            throw new ColorNotFoundException(colorName);
        }
    }
}
