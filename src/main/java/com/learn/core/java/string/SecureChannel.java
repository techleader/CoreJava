package com.learn.core.java.string;

import org.junit.Assert;

public class SecureChannel {
    static String secureChannel(int operation, String message, String key) {
        String invalidCombination = "-1";
        if (key == null || message == null   )  {
            return invalidCombination;
        } else if (message == null || message.equals("")) {
            return invalidCombination;
        } else if (!key.matches("^[0-9]+$")) {
            return invalidCombination;
        }
        switch (operation) {
            case 1:
                return encode(message,key);
            case 2:
                return decode(message,key);
        }
        return invalidCombination;

    }

    static String encode(String message, String key) {
        StringBuffer result = new StringBuffer();
        int i;
        for(i = 0; i<message.length() && i<key.length(); i ++) {
            char c = message.charAt(i);
            int n = Integer.parseInt(String.valueOf(key.charAt(i)));
            for(int j = 0;  j < n ; j++) {
                result.append(c);
            }
        }
        if(message.length()>i){
            result.append(message.substring(i));
        }
        return result.toString();
    }

    static String decode(String message, String key) {
        StringBuffer result = new StringBuffer();
        int mlen = message.length();
        int j = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = message.charAt(j);
            int n = Integer.parseInt(String.valueOf(key.charAt(i)));
            result.append(message.charAt(j));
            j = j + n;
            if (j>= mlen) {
                break;
            } else if(!message.substring(j-n,j).replace(String.valueOf(c),"").equals("")){
                return "-1";
            }
        }
        if (message.length() >= j) {
            result.append(message.substring(j));
        } else {
            return "-1";
        }
        return result.toString();
    }

    static String decode1(String message, String key) {
        StringBuffer result = new StringBuffer();
        int mlen = message.length();
        int j = 0;
        for(int i = 0; i<key.length(); i ++) {
            char c = message.charAt(j);
            int n = Integer.parseInt(String.valueOf(key.charAt(i)));
            j = j+n;
            if(j>=mlen){
                return "-1";
            } else {
                result.append(c);
            }
        }
        if(message.length()>j){
            result.append(message.substring(j));
        }
        return result.toString();
    }

    public static void main(String[] args) {
      //  Assert.assertEquals("-1",secureChannel(1,"Oppen","121"));

        Assert.assertEquals("-1",secureChannel(1,"Oppen",""));
        Assert.assertEquals("-1",secureChannel(1,"",""));
        Assert.assertEquals("Opppen",secureChannel(1,"Oppen","1211"));
        Assert.assertEquals("OOOpppen",secureChannel(1,"Oppen","32"));
        Assert.assertEquals("Oppen",secureChannel(2,"OOOpppen","32"));

        Assert.assertEquals("Opppen",secureChannel(1,"Oppen","1211"));
        Assert.assertEquals("Opppen",secureChannel(1,"Oppen","1211"));
        Assert.assertEquals("Opppen",secureChannel(1,"Oppen","1211"));
        Assert.assertEquals("-1",secureChannel(2,"Opeidfkfdfdfdfpen","18"));
        Assert.assertEquals("Open",secureChannel(2,"Oppeeennnn","1234"));


        Assert.assertEquals("-1",secureChannel(2,"Oppen","8"));




        System.out.println("Pass");
    }
}
