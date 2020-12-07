package comeniusjava.controller.commands;

import comeniusjava.game.commands.MoveCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MoveCommandFactoryTest {
    private static final MoveCommandFactory FACTORY = new MoveCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        MoveCommand result = FACTORY.createFromText("move 12");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        MoveCommand result = FACTORY.createFromText("background 546");
        assertNull("Check if command not created", result);
    }
}
