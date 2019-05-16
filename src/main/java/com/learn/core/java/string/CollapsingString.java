package com.learn.core.java.string;

public class CollapsingString {
    public static void main(String[] args) {
        System.out.println(collapseString("GGGGrrrrrrT"));
        System.out.println(collapseString("GG T"));
        System.out.println(collapseString("GGrT"));
        System.out.println(collapseString("GG%%GG rrrT"));
        System.out.println(collapseString("aaaAAAbbBB--"));
        System.out.println(collapseString("&&&aaaAAAbbBB--"));

    }

    public static String collapseString(String inputString) {
        String regex = "^[a-zA-Z0-9]+$";
        if( inputString == null || inputString.equals("")) {
            return "";
        } else if(inputString.length() ==1) {
            return "1"+inputString;
        }
        System.out.println("Regex matches " + inputString + " => " + inputString.matches(regex));

        StringBuffer stringBuffer = new StringBuffer("");
        int len = 1;
        char currentChar = inputString.charAt(0);
        for(int i=1; i<inputString.length(); i++) {
            char c = inputString.charAt(i);
            if(!String.valueOf(currentChar).matches(regex)){
                currentChar=c;
                continue;
            }
            if(currentChar == c ) {
              len++;
            } else {
                stringBuffer.append(len).append(currentChar);
                len =1;
                currentChar = c;
            }
        }
        if(!String.valueOf(currentChar).matches(regex)){
            stringBuffer.append(len).append(currentChar);
        }
        return stringBuffer.toString();
    }

    public static String collapseString2(String inputString) {
        if (inputString == null || inputString.equals("")) {
            return "";
        } else if (inputString.length() == 1) {
            return "1" + inputString;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        int len = 1;
        char currentChar = inputString.charAt(0);
        for (int i = 1; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (currentChar == c) {
                len++;
            } else {
                stringBuffer.append(len).append(currentChar);
                len = 1;
                currentChar = c;
            }
        }
        stringBuffer.append(len).append(currentChar);
        return stringBuffer.toString();
    }
}
