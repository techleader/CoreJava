package com.learn.core.java.string;

/**
 * Created by Admin on 07-07-2016.
 */
public class StringUtils {

    public static void findLCSSubstr(String str) {
        String result = "", maxResult = "";
        for (int i = 0; i < str.length(); i++) {
            result = str.substring(i, 1);
            while (str.indexOf(result, i + 1) != -1) {
                i++;
                result += str.substring(i, 1);
            }
            result = "";
            if (result.length() > maxResult.length()) {
                maxResult = result;
            }
        }
        System.out.println("StringS : " + result);
    }

    public static boolean isEmpty(String string){
        return (string==null || string.length()==0) ? true : false;
    }

    public static void main(String... s){
        findLCSSubstr("banana");
    }

}
