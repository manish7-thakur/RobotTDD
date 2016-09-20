import com.xebia.Item;
import com.xebia.ItemBuilder;
import com.xebia.Robot;
import com.xebia.exception.CannotWalkException;
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
    public void redLightOffAgain() throws CannotWalkException {
        r.walk(3);
        Assert.assertEquals(r.isRedLightOn(), false);
    }
    @Test
    public void redLightOn() throws CannotWalkException {
        r.walk(4.5);
        Assert.assertEquals(r.isRedLightOn(), true);
    }

    @Test
    public void batteryStatusForHalfDistance() throws CannotWalkException {
        r.walk(2.5);
        Assert.assertEquals(r.getBattery(), 50, 0.5);
    }

    @Test
    public void walkingWithWeight() throws CannotWalkException {
        r.putWeight(5);
        r.walk(2.5);
        Assert.assertEquals(r.getBattery(), 40, 0.5);
    }

    @Test(expected = CannotWalkException.class)
    public void walkingWithTooMuchWeight() throws CannotWalkException {
        r.putWeight(11);
        r.walk(1);
    }

    @Test
    public void barCodeScanReturns20(){
        Item item = ItemBuilder.withBarCode("5555");
        r.scan(item);
        Assert.assertEquals("20", r.getCurrentStatus());
    }
    @Test
    public void barCodeScanReturns40(){
        Item item = ItemBuilder.withBarCode("88888");
        r.scan(item);
        Assert.assertEquals("40", r.getCurrentStatus());
    }

    @Test
    public void displayStatusScanFailure(){

        Item item = ItemBuilder.withBarCode("blurred12434");
        r.scan(item);
        Assert.assertEquals("Scan Failure",r.getCurrentStatus()
        );
    }

}
