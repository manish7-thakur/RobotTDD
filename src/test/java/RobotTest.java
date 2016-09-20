import com.xebia.Robot;
import org.junit.Assert;
import org.junit.Test;

public class RobotTest {
    Robot r  = new Robot();

    @Test
    public void initialDisplayWelcome() {
        Assert.assertEquals("Welcome", r.getCurrentStatus());
    }

    @Test
    public void displayMessageOverweight() {
        r.putWeight(11);
        Assert.assertEquals("Overweight", r.getCurrentStatus());
    }

    @Test
    public void redLightOff() {
        Assert.assertEquals(r.isRedLightOn(), false);
    }

    @Test
    public void redLightOn() {
        r.walk(4.5);
        Assert.assertEquals(r.isRedLightOn(), true);
    }

}
