package com.learn.core.java.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatingCharInString {
    public static void main(String[] args) {
        FirstRepeatingCharInString o = new FirstRepeatingCharInString();
        o.repeatingChar("thisisjawahar");
        o.repeatingChar("thistishjjawaharz");
        o.repeatingChar("tihszishjjawahar");
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
            if(charCount.get(c) > 1) {
                return c;
            }
        }
        return 0;
    }


    private void repeatingChar(String string) {
        Map<Character, Integer> charCount = new HashMap();
        System.out.println("No repeating char for string '" + string + "' [hashMap]=> " +  nonRepeatingCharInString(string,charCount));
        charCount = new LinkedHashMap<>();
        System.out.println("No repeating char for string '" + string + "' [LinkedHashMap]=> " +  nonRepeatingCharInString(string,charCount));
    }
}