package comeniusjava.controller.commands;

import comeniusjava.game.commands.CircleCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CircleCommandFactoryTest {
    private static final CircleCommandFactory FACTORY = new CircleCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        CircleCommand result = FACTORY.createFromText("circle 5");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        CircleCommand result = FACTORY.createFromText("move 546");
        assertNull("Check if is not created", result);
    }

}
