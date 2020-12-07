package comeniusjava.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JdkElfTest {
    @Test
    public void test_creation() throws Exception {
        JdkElf jdkElf = new JdkElf();
        assertNotNull("Test if elf was created", jdkElf);
    }

    @Test
    public void test_default_orientation() throws Exception {
        JdkElf jdkElf = new JdkElf();
        assertEquals(Rotation.FORWARD, jdkElf.getOrientation());
    }

    @Test
    public void test_setOrientation() throws Exception {
        JdkElf jdkElf = new JdkElf();
        jdkElf.setOrientation(Rotation.BACKWARD);
        assertEquals(Rotation.BACKWARD, jdkElf.getOrientation());
    }

    @Test
    public void test_default_position() throws Exception {
        JdkElf jdkElf = new JdkElf();
        assertEquals(0, jdkElf.getPosition().getX());
        assertEquals(0, jdkElf.getPosition().getY());
    }

    @Test
    public void test_setPosition() throws Exception {
        JdkElf jdkElf = new JdkElf();
        jdkElf.setPosition(new Position(1, 2));
        assertEquals(1, jdkElf.getPosition().getX());
        assertEquals(2, jdkElf.getPosition().getY());
    }

    @Test
    public void test_setHome() throws Exception {
        JdkElf jdkElf = new JdkElf();
        jdkElf.setPosition(new Position(1, 2));
        jdkElf.setHome();
        assertEquals(0, jdkElf.getPosition().getX());
        assertEquals(0, jdkElf.getPosition().getY());
    }

    @Test
    public void test_setElfDefault() throws Exception {
        JdkElf jdkElf = new JdkElf();
        jdkElf.getPen().setPenThickness(3);
        assertEquals(3, jdkElf.getPen().getPenThickness());
        jdkElf.setElfDefault();
        assertEquals(Rotation.FORWARD, jdkElf.getOrientation());
        assertEquals(0, jdkElf.getPosition().getX());
        assertEquals(0, jdkElf.getPosition().getY());
        assertEquals(1, jdkElf.getPen().getPenThickness());
    }

    @Test
    public void test_default_tostring() throws Exception {
        JdkElf jdkElf = new JdkElf();
        assertNotNull(jdkElf.toString());
    }
}
