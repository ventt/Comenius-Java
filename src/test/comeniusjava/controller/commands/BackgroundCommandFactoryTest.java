package comeniusjava.controller.commands;


import comeniusjava.game.color.ColorNotFoundException;
import comeniusjava.game.commands.BackgroundCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class BackgroundCommandFactoryTest {

    @Test
    public void test_valid_command() throws Exception {
        BackgroundCommandFactory factory = new BackgroundCommandFactory();
        BackgroundCommand result = factory.createFromText("background yellow");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_valid_default_command() throws Exception {
        BackgroundCommandFactory factory = new BackgroundCommandFactory();
        BackgroundCommand result = factory.createFromText("background default");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        BackgroundCommandFactory factory = new BackgroundCommandFactory();
        BackgroundCommand result = factory.createFromText("move 546");
        assertNull("Check if command was created", result);
    }

    @Test(expected = ColorNotFoundException.class)
    public void test_invalid_color() throws Exception {
        BackgroundCommandFactory factory = new BackgroundCommandFactory();
        factory.createFromText("background invalid");
    }
}