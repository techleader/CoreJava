package com.learn.core.java.dynamic;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

/**
 * 
 * @author Jawahar
 *
 *         Problem description :
 *         https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *         
 *         
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		DataSet data = new DataSet();
		data.accept(new LISRecursive());
		data.accept(new LISDynamicProgrammingBottomUp());
	}

	private static class LISRecursive implements Visitor{
		
		@Override
		public int visit(int[] items) {
			return findLIS(items);
		}

		private int findLIS(int[] input) {
			return findLIS(input, input.length - 1);
		}

		private int findLIS(int[] input, int i) {
			int length = 0;
			if (i == 0) {
				return 1;
			}
			int len = findLIS(input, i - 1);
			if (input[i] > input[i - 1]) {
				length = 1 + len;
			} else {
				length = len;
			}
			return length;
		}
	}

	private interface Visitor {
		int visit(int[] items);
	}

	private static class DataSet {
		int[] a = { 3, 10, 2, 1, 20 };
		int[] b = { 3, 2 };
		int[] c = { 50, 5, 3, 10, 7, 40, 80, 50 };

		void accept(Visitor visitor) {
			LocalTime start = LocalTime.now();
			assertEquals(3, visitor.visit(a));
			assertEquals(1, visitor.visit(b));
			assertEquals(4, visitor.visit(c));
			LocalTime end = LocalTime.now();
			long nano = end.getNano() - start.getNano();
			System.out.println("Completed Successfully, Time taken in secs " + (nano / 1000000.0) + "; nono: " + nano);

		}

	}

	private static class LISDynamicProgrammingBottomUp implements Visitor {

		@Override
		public int visit(int[] items) {
			return findLIS(items);
		}

		private int findLIS(int[] input) {
			int[] output = new int[input.length];
			int max = 1;

			output[0] = 1;
			for (int i = 1; i < input.length; i++) {
				if (input[i] > input[i - 1]) {
					output[i] = output[i - 1] + 1;
					max = output[i];
				} else {
					output[i] = output[i - 1];
				}
			}
			return max;
		}

	}

}
