package com.learn.core.java.parkingSystem;

/**
 * Created by Meetansh on 18-07-2016.
 */
public class CarDetail {
    int CarNo;
    int startTime;
    int endTime;
    int charge;

    public int getCarNo() {
        return CarNo;
    }

    public void setCarNo(int carNo) {
        CarNo = carNo;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }
}
