package comeniusjava.controller.commands;

import comeniusjava.game.commands.ThicknessCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ThicknessCommandFactoryTest {
    private static final ThicknessCommandFactory FACTORY = new ThicknessCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        ThicknessCommand result = FACTORY.createFromText("pen thickness 5");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        ThicknessCommand result = FACTORY.createFromText("move 546");
        assertNull("Check if command not created", result);
    }

    @Test(expected = Exception.class)
    public void test_invalid_value() throws Exception {
        FACTORY.createFromText("pen thickness bla");
    }
}
