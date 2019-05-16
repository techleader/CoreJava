package com.learn.core.java.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Meetansh on 16-03-2017.
 *
 * Jeremy and Clara are learning about passwords and created a game to test their "hacking" skills. Jeremy made rules for valid passwords and Clara needs to write a program to generate all possible passwords that meet those rules. Jeremy's rules are these:

 a password consists of exactly  lowercase English letters.
 the password is melodious, meaning that consonants can only be next to vowels and vowels can only be next to consonants. Example: bawahaha
 the password cannot contain the letter y (because it's both a consonant and vowel).
 the first letter of the password can be either a vowel or consonant.

 a-z : 97 - 122
 */

public class MelodiousPassword {

    static int vovels[] = {97,101,105,111,117};
    static int notallowed = 121;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
         printPasswords(n);
    }

    public static void printPasswords(int n){
        if(n <1 && n>6 ) return;
        generatePassword(n,"");
        return;
    }

    private static boolean isVovel(int no) {
        return true;// Arrays.stream(vovels).filter( i ->  i == no).count() == 1;
    }

    private static void generatePassword(int len, String password) {
        appendConsonents(len,password);
        appendVovels(len,password);
    }

    private static void appendConsonents(int len, String password){
        if(len == password.length()){
            System.out.println(password);
            return;
        }
        for(int i=97 ; i<=121 ; i++) {
            if(!isVovel(i) && i!=notallowed ){
                appendVovels(len,password +(char)i);
            }
        }

    }
    private static void appendVovels(int len, String password){
        if(len == password.length()) {
            System.out.println(password);
            return;
        }
        for(int i : vovels) {
            appendConsonents(len,password +(char)i);
        }
    }

}
