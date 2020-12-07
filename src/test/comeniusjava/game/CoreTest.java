package comeniusjava.game;

import comeniusjava.controller.commands.BackgroundCommandFactory;
import comeniusjava.controller.commands.DrawingCommandFactory;
import comeniusjava.controller.commands.MoveCommandFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoreTest {

    public static final String TEMP_TXT = "temp.txt";

    /**
     * Source: https://stackoverflow.com/questions/8256989/singleton-and-unit-testing
     *
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Core.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);

    }

    @After
    public void deleteSave() {
        Path.of(TEMP_TXT).toFile().delete();
    }

    @Test
    public void clear() throws Exception {
        Core.getInstance().getCommands().add(new DrawingCommandFactory().createFromText("pen down"));
        Core.getInstance().getCommands().add(new MoveCommandFactory().createFromText("move 10"));
        Core.getInstance().getCommands().add(new BackgroundCommandFactory().createFromText("background red"));
        Core.getInstance().doCommands();

        Core.getInstance().clear();

        assertEquals(Color.LIGHT_GRAY, Core.getInstance().getBackGroundColor());
        Position position = Core.getInstance().getElf().getPosition();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void doCommands() throws Exception {
        Core.getInstance().getCommands().add(new DrawingCommandFactory().createFromText("pen down"));
        Core.getInstance().getCommands().add(new MoveCommandFactory().createFromText("move 10"));
        Core.getInstance().getCommands().add(new BackgroundCommandFactory().createFromText("background red"));
        Core.getInstance().doCommands();

        assertEquals(Color.RED, Core.getInstance().getBackGroundColor());
        Position position = Core.getInstance().getElf().getPosition();
        assertEquals(0, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    public void setDefault() {
    }

    @Test
    public void save() throws Exception {
        Core.getInstance().getCommands().add(new DrawingCommandFactory().createFromText("pen down"));
        Core.getInstance().getCommands().add(new MoveCommandFactory().createFromText("move 10"));
        Core.getInstance().getCommands().add(new BackgroundCommandFactory().createFromText("background red"));
        Core.getInstance().doCommands();

        Core.getInstance().save(TEMP_TXT);

        assertTrue(Path.of(TEMP_TXT).toFile().exists());
        assertTrue(Path.of(TEMP_TXT).toFile().length() > 0);
    }

    @Test
    public void load_valid() throws Exception {
        Core.getInstance().getCommands().add(new DrawingCommandFactory().createFromText("pen down"));
        Core.getInstance().getCommands().add(new MoveCommandFactory().createFromText("move 10"));
        Core.getInstance().getCommands().add(new BackgroundCommandFactory().createFromText("background red"));
        Core.getInstance().doCommands();

        Core.getInstance().save(TEMP_TXT);
        Core.getInstance().clear();

        Core.getInstance().load(TEMP_TXT);
        Core.getInstance().doCommands();
        assertEquals(Color.RED, Core.getInstance().getBackGroundColor());
        Position position = Core.getInstance().getElf().getPosition();
        assertEquals(0, position.getX());
        assertEquals(10, position.getY());
    }

    @Test(expected = FileNotFoundException.class)
    public void load_invalid() throws Exception {
        Core.getInstance().load(TEMP_TXT);
    }
}