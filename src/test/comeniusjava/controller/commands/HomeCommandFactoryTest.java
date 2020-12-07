package comeniusjava.controller.commands;

import comeniusjava.game.commands.HomeCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class HomeCommandFactoryTest {
    private static final HomeCommandFactory FACTORY = new HomeCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        HomeCommand result = FACTORY.createFromText("home");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        HomeCommand result = FACTORY.createFromText("move 546");
        assertNull("Check if command not created", result);
    }
}
