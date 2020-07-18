package com.learn.core.java.rajesh;

import com.learn.core.java.coderpad.StudentResult;


import java.util.*;

public class HashCodeAndEqualMethod {

    public static void main(String[] args) {
        StudentResult e1 = new StudentResult(1,60);
        StudentResult e3 = new StudentResult(3, 85);
        StudentResult e4 = new StudentResult(4, 50);

        Map<StudentResult,String> student = new HashMap<>();

        student.put(e1,"mitansh");
        student.put(e3,"jls");
        student.put(e4,"vijay");

;
        StudentResult newEmp = new StudentResult(1, 60);

       System.out.println( student.get(newEmp));

        /*Set<StudentResult> set = new HashSet<>();
        set.add(new StudentResult(1, 60));
        System.out.println("set contrain this object is " +set.contains(new StudentResult(1, 60)));*/
   }
}
