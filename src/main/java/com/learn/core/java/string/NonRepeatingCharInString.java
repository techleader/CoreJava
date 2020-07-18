package com.learn.core.java.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NonRepeatingCharInString {
    public static void main(String[] args) {
        NonRepeatingCharInString o = new NonRepeatingCharInString();
        o.printNoRepeatingChar("thisisjawahar");
        o.printNoRepeatingChar("thistishjjawaharz");
        o.printNoRepeatingChar("thistzishjjawahar");
    }


    private char nonRepeatingCharInString(String string, Map<Character, Integer> charCount) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        for(int i = 0; i<string.length() ; i++) {
            char c = string.charAt(i);
            Integer count = charCount.getOrDefault(c,0);
            count++;
            charCount.put(c,count);
        }
        for(Character c : charCount.keySet()) {
            if(charCount.get(c) == 1) {
                return c;
            }
        }
        return 0;
    }


    private void printNoRepeatingChar(String string) {
        Map<Character, Integer> charCount = new HashMap();
        System.out.println("No repeating char for string '" + string + "' [hashMap]=> " +  nonRepeatingCharInString(string,charCount));
        charCount = new LinkedHashMap<>();
        System.out.println("No repeating char for string '" + string + "' [LinkedHashMap]=> " +  nonRepeatingCharInString(string,charCount));
    }
}
