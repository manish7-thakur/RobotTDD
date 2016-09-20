package com.xebia;

public class Robot {

    private int currentLoad = 0 ;
    private String currentStatus = "Welcome";
    private boolean redLightOn  = false;

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void putWeight(int i) {
        this.currentLoad += i;
        if(currentLoad > 10) {
            this.currentStatus = "Overweight";
        }
    }

    public boolean isRedLightOn() {

        return redLightOn;
    }
}
