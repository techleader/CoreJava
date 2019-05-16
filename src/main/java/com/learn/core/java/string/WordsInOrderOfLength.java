package com.learn.core.java.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class WordsInOrderOfLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        System.out.println(solution1(line));
    }


    //Best Solution
    public static String solution1(String line) {
        String[] arr = line.split(" +");
        Arrays.sort(arr, (o1, o2) -> {
            return ((String)o1).length() - ((String)o2).length();
        });

        return Arrays.toString(arr).replaceAll("[^a-zA-Z ]", "");
    }


    public static String solution3(String line) {
        int current = 0;
        int start = 0;
        int len = line.length();
        TreeMap<String,Integer> set = new TreeMap<String, Integer>((o1, o2) -> {
            return (o1.length()!=o2.length()) ? o1.length()-o2.length():0;
        });
        while(current<len) {
            if((line.charAt(current) == ' ' || current+1== len ) && current>start) {
                String substr = line.substring(start, current + ((len-1-current == 0)?1:0));
                System.out.println(substr);
                set.put(substr, substr.length());
                start = current+1;
            }
            current++;
        }
        return set.keySet().toString().replaceAll("[^a-zA-Z ]", "");
    }




    }
