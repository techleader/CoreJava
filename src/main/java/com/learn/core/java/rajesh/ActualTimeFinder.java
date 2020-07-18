package com.learn.core.java.rajesh;

public class ActualTimeFinder {
    int hour;
    int minit;
    int second;

    public ActualTimeFinder(int hour, int minit, int second) {
        this.hour = hour;
        this.minit = minit;
        this.second = second;
    }

    public void timeCalculator(){

        while(second>60){
            second = second-60;
            minit++;
        }

        while(minit>60){
            minit=minit-60;
            hour++;
        }
        System.out.println(hour+":"+minit+":"+second);
    }

    public static void main(String[] args) {

        ActualTimeFinder actualTimeFinder = new ActualTimeFinder(10,120,125);
        actualTimeFinder.timeCalculator();
        System.out.println(70/60+" "+10%60);

    }
}
