package comeniusjava.controller.commands;

import comeniusjava.game.color.ColorNotFoundException;
import comeniusjava.game.commands.ColorCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ColorCommandFactoryTest {
    private static final ColorCommandFactory FACTORY = new ColorCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        ColorCommand result = FACTORY.createFromText("color yellow");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        ColorCommand result = FACTORY.createFromText("move 546");
        assertNull("Check if command not created", result);
    }

    @Test(expected = ColorNotFoundException.class)
    public void test_invalid_color() throws Exception {
        FACTORY.createFromText("color invalid");
    }
}
