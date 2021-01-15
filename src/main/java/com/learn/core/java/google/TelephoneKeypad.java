package com.learn.core.java.google;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.learn.core.java.utils.Tries;

/**
 * Problem
 * https://www.geeksforgeeks.org/find-possible-words-phone-digits/
 * 
 * Given a no. 5576465 and word array {JLS,INK,ROS,TAT}
 * Find out what words are possible from phone keypad 
 * 
 * @author Jawahar
 * @date - 13-Jan-2021
 *
 */
public class TelephoneKeypad {
	
	public static void main(String[] args) {
		
		//Number representation for {JLS,INK,ROS,TAT} as {557,465,767,828}
		//Making tries for these words
		
		Tries tries = new Tries();
		String[] words = new String[] {"foo","bar","baz","foobar","emo","cap","car","cat"};
		for(String word : words) {
			tries.addNode(word);
		}		
		System.out.println(solve("3662277", words) );
	}
	
	
	public static List<String> solve(String no, String[] words) {
		List<String> items = new ArrayList<String>() ;
		for(String word : words) {
			if(no.contains(toNumberString(word))) {
				items.add(word);
			}
		}
		return items;
	}
	
	public static void test() {
		Tries tries = new Tries();
		tries.addNode(toNumberString("jhl"));
		tries.addNode("5450");
		tries.addNode("5450851");
		tries.addNode("577");
		tries.print();
		assertTrue(tries.match("545"));		
		assertTrue(tries.match("5450"));
		assertTrue(tries.match("577"));
		assertFalse(tries.match("54"));
	}
	
	private static String toNumberString(String word) {
		
		int[] map = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		String noString = new String();
		for(char c : word.toCharArray()) {
			noString += map[c-'a'];
		}
		return noString;		
	}
	
	
	

}
