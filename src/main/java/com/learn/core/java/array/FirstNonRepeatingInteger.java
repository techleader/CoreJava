package com.learn.core.java.array;

import static org.junit.Assert.assertEquals;

public class FirstNonRepeatingInteger {

	public static void main(String[] args) {
		
		int[] a = { 45, 60, 85, 45, 10, 3, 6 };
		assertEquals(60,a);

	}

	private void firstNonRepeatingNo(int[] a) {		

		for (int i = 0; i < a.length-1; i++) {
			int no = a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (no == a[j]) {
					break;
				}
			}

		}
	}

}
