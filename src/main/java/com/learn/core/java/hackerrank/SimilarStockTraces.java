package com.learn.core.java.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class SimilarStockTraces {

    public static void main(String[] args) {

        List<Integer> s = Arrays.asList(67,3,3,3);
        List<Integer> t = Arrays.asList(67,26,26,26);
        System.out.println(tracesAreSimilar(s,t));

    }


    public static String tracesAreSimilar(List<Integer> s, List<Integer> t) {
        String NO = "NO";
        if(s == null || t == null) { return NO; }
        else if(s.size() != t.size()) { return NO; }
        Map<Integer,Long> occurancesInS  = countOccurances(s);
        Map<Integer,Long> occurancesInT  = countOccurances(t);
        for(Integer key : occurancesInS.keySet()){
            Long traceInS = occurancesInS.get(key);
            Long traceInT = occurancesInT.get(key);
            if(traceInT!= null) {
                if(Math.abs(traceInS-traceInT)>3){
                    return NO;
                }
                occurancesInT.remove(key);
            } else if(traceInS>3){
                return NO;
            }
        }
        for(Integer key : occurancesInT.keySet()){
            Long traceInS = occurancesInS.get(key);
            Long traceInT = occurancesInT.get(key);
            if(traceInS!= null && traceInT!=null) {
                if(Math.abs(traceInS-traceInT)>3){
                    return NO;
                }
            } else if(traceInT>3){
                return NO;
            }
        }

        return "YES";
    }

    public static Map<Integer,Long> countOccurances(List<Integer> list){
        return list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

}
