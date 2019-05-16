package com.learn.core.java.parkingSystem;


import java.util.ArrayList;

/**
 * Created by Meetansh on 18-07-2016.
 */

interface Parking{

    public boolean getParkingAvailabity(ArrayList<CarDetail> lots);
    public void alotPraking();

}
public class ParkingSystem implements Parking{
   static int parkingAlot=5;
   static boolean parking;

    @Override
    public boolean getParkingAvailabity(ArrayList<CarDetail> lots) {

        if(lots.size()!=parkingAlot)
                parking=true;
        else
            parking=false;

        return parking;
    }

    @Override
    public void alotPraking() {

    }

    public static void main(String arg[]){
        ArrayList<CarDetail> alotparking=new ArrayList<>();
        ParkingSystem pr=new ParkingSystem();
         if(pr.getParkingAvailabity(alotparking)==true){
            CarDetail c=new CarDetail();
             c.setCarNo(123);


         }

    }
}
