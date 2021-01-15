package com.learn.core.java.dynamic;

import static com.learn.core.java.utils.TimeRecordedTask.execute;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Meetansh on 16-07-2016.
 */
public class CoinProblem {

	public static void main(String... s) {
		execute(() -> {	assertEquals(3, count(new int[] { 1, 2 }, 4)); });
		execute(() -> {	assertEquals(3, count(new int[] { 1, 2 }, 5)); });
		execute(() -> {	assertEquals(4, count(new int[] { 1, 2, 3 }, 4)); });
		execute(() -> {	assertEquals(377, count(new int[] { 1, 2, 3,4,5 },25)); });
	}

	
	private static int count(int coins[], int n) {
		if (n < 0) {
			return 0;
		} else {
			return count(coins, coins.length - 1, n);
		}
	}

	private static int count(int coins[], int m, int n) {
		if (n < 0 || m < 0) {
			return 0;
		} else if (n == 0 && m >= 0) {
			return 1;
		}
		int m1 = count(coins, m - 1, n);
		int m2 = count(coins, m, n - coins[m]);
		return m1 + m2;
	}
	
	
	public static void takeInput() {
		// System.out.println(count(new int[]{1,2,3}, 3 , 4));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			if (line == null) {
				return;
			}
			String[] arr = line.trim().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			if (n < 1 || n > 250 || m < 1 || m > 50)
				return;

			int a[] = new int[m];
			line = br.readLine();
			if (line == null) {
				return;
			}
			arr = line.trim().split(" ");
			if (arr.length < m) {
				return;
			}
			for (int i = 0; i < m; i++) {
				a[i] = Integer.parseInt(arr[i]);
			}
			System.out.println(count(a, m, n));
		} catch (Exception e) {
			System.out.println(0);
		} finally {

		}
	}

	

}
