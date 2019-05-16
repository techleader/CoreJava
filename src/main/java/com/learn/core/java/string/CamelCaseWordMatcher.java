package com.learn.core.java.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Admin on 08-07-2016.
 *
 * Write a function that given a List and a pattern returns the matching elements.
     ['HelloMars', 'HelloWorld', 'HelloWorldMars', 'HiHo']
     H -> [HelloMars, HelloWorld, HelloWorldMars, HiHo]
     HW -> [HelloWorld, HelloWorldMars]
     Ho -> []
     HeWorM -> [HelloWorldMars]
 *
 */
public class CamelCaseWordMatcher {

    public static void main(String... s){

        List<String> words = new ArrayList<>();
        words.add("HelloMars");
        words.add("HelloWorld");
        words.add("HelloMarsWorld");
        words.add("HiHo");
        System.out.println("--------------- Input Data ----");
        words.stream().forEach(System.out::println);
        System.out.println("--------------- Pattern H ----");
        words.stream().filter(word -> isWordMatching(word,"H")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------- Pattern HeMarW ----");
        words.stream().filter(word -> isWordMatching(word,"HeMarW")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------- Pattern HW ----");
        words.stream().filter(word -> isWordMatching(word,"HW")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------- Pattern HM ----");
        words.stream().filter(word -> isWordMatching(word,"HM")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------- Pattern Hi ----");
        words.stream().filter(word -> isWordMatching(word,"Hi")).collect(Collectors.toList()).forEach(System.out::println);

    }

    public static boolean isWordMatching(String word, String pattern) {
        if(StringUtils.isEmpty(word) || StringUtils.isEmpty(pattern)){
            return false;
        }
        List<String> matchingWords = new ArrayList<>();
        int indexWord =0 , indexPattern = 0;
        boolean compare = true;
        boolean skipWordCharsTillCapitalLetterIsFound = false;


        while (indexPattern<pattern.length() && indexWord<word.length()){
            char w = word.charAt(indexWord);
            char p = pattern.charAt(indexPattern);
            indexWord++;
            if(skipWordCharsTillCapitalLetterIsFound ){
                if(!isUpperCase(w)){
                    continue;
                } else{
                    skipWordCharsTillCapitalLetterIsFound = false;
                    compare = true;
                }
            }
            if(compare && w !=p) {
                return false;
            }
            indexPattern++;
            if((indexPattern)<pattern.length() && isUpperCase(pattern.charAt(indexPattern))){
                skipWordCharsTillCapitalLetterIsFound = true;
            }
        }

        return  true & !skipWordCharsTillCapitalLetterIsFound;
    }

    static boolean isUpperCase(char c){
        return (c >= 65 && c<=91);
    }




}
