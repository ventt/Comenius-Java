package comeniusjava.controller.commands;

import comeniusjava.game.commands.RotateCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RotateCommandFactoryTest {
    private static final RotateCommandFactory FACTORY = new RotateCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        RotateCommand result = FACTORY.createFromText("rotate left");
        assertNotNull("Check if command was created", result);
        result = FACTORY.createFromText("rotate forward");
        assertNotNull(result);
        result = FACTORY.createFromText("rotate backward");
        assertNotNull(result);
        result = FACTORY.createFromText("rotate right");
        assertNotNull(result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        RotateCommand result = FACTORY.createFromText("move 546");
        assertNull("Check if command not created", result);
    }
}
