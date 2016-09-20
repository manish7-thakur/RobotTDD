package com.xebia;

import com.xebia.Item;
import com.xebia.builders.ItemBuilder;
import com.xebia.Robot;
import com.xebia.exception.CannotWalkException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {
    private Robot r;
    private ItemBuilder itemBuilder;

    @Before
    public void setUp() {
        r = new Robot();
        itemBuilder = new ItemBuilder();
    }

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
        r.putWeight(12);
        r.walk(1);
    }

    @Test
    public void barCodeScanReturns20() {

        Item item = itemBuilder.withBarCode("5555")
                .withName("Some name").get();
        r.scan(item);
        Assert.assertEquals("20", r.getCurrentStatus());
    }

    @Test
    public void barCodeScanReturns40() {
        Item item = itemBuilder.withBarCode("88888")
                .withName("Some other name").get();
        r.scan(item);
        Assert.assertEquals("40", r.getCurrentStatus());
    }

    @Test
    public void displayStatusScanFailure() {

        Item item = itemBuilder.withBarCode("blurred12434").get();
        r.scan(item);
        Assert.assertEquals("Scan Failure", r.getCurrentStatus()
        );
    }

    @Test
    public void walkingWith3andAHalfKm() throws CannotWalkException {
        r.walk(3.5);
        Assert.assertEquals(30, r.getBattery(), 0.5);
    }


    @Test
    public void walkingWith2kmAnd3KgWeight() throws CannotWalkException {
        r.putWeight(3);
        r.walk(2);
        Assert.assertEquals(54, r.getBattery(), 0.5);
    }


}
