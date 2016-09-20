package com.xebia;

import com.xebia.exception.CannotWalkException;

public class Robot {

    private int currentLoad = 0 ;
    private String currentStatus = "Welcome";
    private boolean redLightOn  = false;
    private double battery = 100;

    public String getCurrentStatus() {
        return currentStatus;
    }


    public void putWeight(int i) {
        this.currentLoad += i;
        checkAndSetDisplayStatus();
    }

    private void checkAndSetDisplayStatus() {
        if(currentLoad > 10) {
            this.currentStatus = "Overweight";
        }
    }

    public boolean isRedLightOn() {
        return redLightOn;
    }

    public void walk(double distanceInKM) throws CannotWalkException {

        if(currentLoad > 10)
        {
            throw new CannotWalkException();
        }
        System.out.println("Walking distanceInKM....." + distanceInKM);

        checkAndStatusAfterWalk(distanceInKM);
    }

    private void checkAndStatusAfterWalk(double distanceInKM) {
        double distanceInMeters = distanceInKM * 1000;
        battery = battery - (2 * distanceInMeters / 100);
        battery -= currentLoad * 2;
        if(battery < 15) {
            setRedLightOn();
        }
    }


    private void setRedLightOn() {
        redLightOn = true;
    }

    public double getBattery() {

        return battery;
    }

    public void scan(Item item) {
        String barcode = item.getBarCode();
        setCurrentStatus(BarCodeHelper.scanBarCode(barcode
        ));
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
