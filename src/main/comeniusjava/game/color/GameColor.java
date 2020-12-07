package comeniusjava.game.color;

import java.awt.*;

/**
 * Szín kódokat és őket leíró Stringek kapcsolatát leíró Enumeráció. Színt tároló osztály és a hozzá tartozó átváltás
 * metódus.
 */
public enum GameColor {
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

    GameColor(Color color) {
        this.color = color;
    }

    /**
     * Visszaadja a {@link GameColor}-t {@link Color} alapjan
     *
     * @param color {@link Color}
     * @return a {@link GameColor}
     */
    public static GameColor getByColor(Color color) {
        for (GameColor appColor : GameColor.values()) {
            if (appColor.getColor().equals(color)) {
                return appColor;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Szoveg alapjan megkeresi a szint
     *
     * @param colorName szoveg
     * @return A keresett szin
     * @throws ColorNotFoundException Ha nem talat szint
     */
    public static Color getColorFromString(String colorName) throws ColorNotFoundException {
        try {
            return GameColor.valueOf(colorName).getColor();
        } catch (IllegalArgumentException e) {
            throw new ColorNotFoundException(colorName);
        }
    }

    public Color getColor() {
        return color;
    }
}
