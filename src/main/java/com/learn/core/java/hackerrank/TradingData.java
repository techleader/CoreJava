package com.learn.core.java.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TradingData {

    public static void main(String[] args) {

        List<Integer> s = Arrays.asList(134,134,134,134);
        List<Integer> t = Arrays.asList(232,1,-156,-156);
        System.out.println(traceCount(s,t));

    }


    public static List<Integer> traceCount(List<Integer> systemA, List<Integer> systemB) {
        List<Integer> result = new ArrayList<>();
        if(systemA == null || systemB == null) { return result; }
        for(Integer itemB : systemB){
            int counter = 0;
            for(Integer itemA: systemA) {
                if(itemA <= itemB) {
                    counter++;
                }
            }
            result.add(counter);
        }
        return result;
    }

    public static Map<Integer,Long> countOccurances(List<Integer> list){
        return list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

}
