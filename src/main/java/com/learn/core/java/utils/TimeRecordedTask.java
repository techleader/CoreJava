package com.learn.core.java.utils;

import java.time.LocalTime;

public class TimeRecordedTask {
	
	public static void execute(Runnable runnable) {
		LocalTime start = LocalTime.now();
		runnable.run();
		LocalTime end = LocalTime.now();
		long nano = end.getNano() - start.getNano();
		System.out.println("Completed Successfully, Time taken in secs " + (nano / 1000000.0) + "; nono: " + nano);
		
	}

}
