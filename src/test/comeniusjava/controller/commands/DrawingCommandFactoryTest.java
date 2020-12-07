package comeniusjava.controller.commands;

import comeniusjava.game.commands.DrawingCommand;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DrawingCommandFactoryTest {
    private static final DrawingCommandFactory FACTORY = new DrawingCommandFactory();

    @Test
    public void test_valid_command() throws Exception {
        DrawingCommand result = FACTORY.createFromText("pen up");
        assertNotNull("Check if command was created", result);
    }

    @Test
    public void test_invalid_command() throws Exception {
        DrawingCommand result = FACTORY.createFromText("move 516");
        assertNull("Check if command was not created", result);
    }


}
