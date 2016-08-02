package com.learn.core.java.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 06-07-2016.
 */
public class StringCombination {
    /**
     * Problem :
     *
     * Given a number print the number of combinations you can derive from the number. 1=A, 2=B, 26=Z, 0=+.

     For example: 1123 can be represented by 1,1,2,3 which would stand for AABC.
     Another representation - 11,23 - JW
     Another representation - 1,1,23 - AAW
     Another representation - 11,2,3 - JBC

     For number 1123, there will be 5 combinations.
     1,1,2,3
     1,12,3
     1,1,23
     11,2,3
     11,23

     For number 23726
     2,3,7,2,6 => bcgcf
     2,3,7,26  =>
     23,7,2,6
     23,7,26

     For number 8218
     8,2,1,8
     8,2,18
     8,21,8

     */

    public static void main(String... s){
        StringCombinationGenerator.decode("1123").forEach(System.out::println);
        System.out.println("...........");
        StringCombinationGenerator.combinations("1123").forEach(System.out::println);

    }
}

class StringCombinationGenerator {

    public static Set<String> combinations(String string){
        return combinations("",string);
    }
    public static Set<String> combinations(String prefix, String string){
        Set<String> numbers = new HashSet<>();
        if(string.length()==0){
            numbers.add(prefix);
            return numbers;
        }
        if (string.charAt(0) == '0'){
            return numbers;
        }
        if(prefix.length()!=0){
            prefix = prefix+",";
        }

        numbers.addAll(combinations(prefix + (char)(string.charAt(0) - '1'+ 'A'),string.substring(1)));

        if(string.length()>=2){
            int num = Integer.parseInt(""+string.substring(0,2));
            if(num >9 && num <20){
                numbers.addAll(combinations(prefix + (char)(10+string.charAt(1) - '1'+ 'A'),string.substring(2)));
            }
            if(num >=20 && num <27){
                numbers.addAll(combinations(prefix + (char)(20+string.charAt(1) - '1'+ 'A'),string.substring(2)));
            }
        }

        return numbers;
    }

    public static Set<String> decode(String code){
        return decode("", code);
    }



    private static Set<String> decode(String prefix, String code) {
        Set<String> set = new HashSet<String>();
        if (code.length() == 0) {
            set.add(prefix);
            return set;
        }
        if (code.charAt(0) == '0'){
            return set;
        }

        set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'), code.substring(1)));

        if (code.length() >= 2 && code.charAt(0) == '1') {
            set.addAll(decode(prefix + (char) (10 + code.charAt(1) - '1' + 'a'), code.substring(2)));
        }
        if (code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6') {
            set.addAll(decode(prefix + (char) (20 + code.charAt(1) - '1' + 'a'), code.substring(2)));
        }
        return set;
    }

}