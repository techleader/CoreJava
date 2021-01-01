package com.learn.core.java.java8;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReference{




    public static void main(String[] args) {
        new MethodReference().type1();
    }

    private  void type1(){
        Type1Interface type1 = Type1::new;
        type1.show("Jawahar ");
    }



    interface  Type1Interface{
        void show(String name);
    }

    class Type1 {
        Type1(String name) {
            System.out.println("type1 constructor - " + name );
        }
    }

}