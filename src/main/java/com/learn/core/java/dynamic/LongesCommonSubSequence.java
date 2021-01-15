package com.learn.core.java.dynamic;

import static org.junit.Assert.assertEquals;

public class LongesCommonSubSequence {
	
	public static void main(String[] args) {	
		assertEquals(3, checkLCS("abcd", "abbdc"));
		assertEquals(3, checkLCS("ABCDGH", "AEDFHR"));
		assertEquals(4, checkLCS("AGGTAB", "GXTXAYB"));
		System.out.println("Completed Successfully");
		
	}
	
	
	private static int checkLCS(String string1, String string2 ) {
		return checkLCS(string1, string1.length()-1, string2, string2.length()-1);
	}
	
	private static int checkLCS(String string1, int i, String string2 , int j) {
		
		if(i<0 || j<0 ) { return 0; }
		
		char c1 = string1.charAt(i);
		char c2 = string2.charAt(j);
		
		if(c1 == c2 ) {
			return 1 + checkLCS(string1, i-1 ,string2, j-1);
		} else {
			int r1 = checkLCS(string1, i-1, string2, j);
			int r2 = checkLCS(string1, i, string2, j-1);
			return Math.max(r1, r2);
		}
	}

}
