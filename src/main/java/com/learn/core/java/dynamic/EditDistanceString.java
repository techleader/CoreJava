package com.learn.core.java.dynamic;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Admin
 *
 */
public class EditDistanceString {
	
	public static void main(String[] args) {	
		assertEquals(1, checkLCS("geek", "gesek"));
		assertEquals(1, checkLCS("cat", "cut"));
		assertEquals(3, checkLCS("sunday", "saturday"));
		
		assertEquals(1, editDistance("geek", "gesek"));
		assertEquals(1, editDistance("cat", "cut"));
		assertEquals(3, editDistance("sunday", "saturday"));

		System.out.println("Completed Successfully");
		
	}
	
	
	private static int checkLCS(String string1, String string2 ) {
		int result = checkLCS(string1, string1.length()-1, string2, string2.length()-1);		
		return string2.length()-result;
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
	
	private static int editDistance(String string1, String string2 ) {
		return editDistance(string1, string1.length()-1, string2, string2.length()-1);
	}
	
	private static int editDistance(String string1, int i, String string2 , int j) {
		
		if(i<0 || j<0 ) { return 0; }
		
		char c1 = string1.charAt(i);
		char c2 = string2.charAt(j);
		
		if(c1 == c2 ) {
			return editDistance(string1, i-1 ,string2, j-1);
		} else {
			int r1 = editDistance(string1, i, string2, j-1);
			int r2 = editDistance(string1, i-1, string2, j);
			int r3 = editDistance(string1, i-1, string2, j-1);
			return Math.min(r3, Math.min(r1, r2));
		}
	}

}
