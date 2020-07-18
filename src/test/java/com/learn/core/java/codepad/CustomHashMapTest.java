package com.learn.core.java.codepad;

import com.learn.core.java.coderpad.CustomHashMap;
import com.learn.core.java.coderpad.StudentResult;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class CustomHashMapTest {
    @Test
    public void testMapInteger(){
        CustomHashMap<Integer,Integer> map = new CustomHashMap<>(10);
        for(int i =0; i<5;i++) {
            map.put(i,100*i);
        }


        for(int i =0; i<5;i++) {
            Assert.assertEquals(100*i,(long)map.get(i));
        }
       map.put(1,300);
        map.put(5,800);

        System.out.println(map.toString());

       Assert.assertEquals(800,(long)map.get(5));

    }

    @Test
    public void testMapString(){
        CustomHashMap<String,String> map = new CustomHashMap<>(5);
        map.put("Hello","Jawahar");
        map.put("Hello","rajesh");
        map.put("Hi","rajesh");
        map.put("Hey","mitansh");

        Assert.assertEquals("rajesh",map.get("Hello"));
        Assert.assertEquals("mitansh",map.get("Hey"));

    }

    @Test
    public void testStudentResult(){
        StudentResult e1 = new StudentResult(1,60);
        StudentResult e2 = new StudentResult(2,70);
        StudentResult e3 = new StudentResult(3,85);

        Map<StudentResult,String> student = new HashMap<>();

        student.put(e1,"mitansh");
        student.put(e3,"jls");
        student.put(e2,"vijay");

        StudentResult newStd = new StudentResult(1, 60);

        Assert.assertEquals("mitansh",student.get(newStd));
    }

    @Test
    public void testMapObject(){
        StudentResult e1 = new StudentResult(1,60);
        StudentResult e2 = new StudentResult(2,70);
        StudentResult e3 = new StudentResult(3,85);

        CustomHashMap<StudentResult,String> map = new CustomHashMap<>(5);

        map.put(e1,"mitansh");
        map.put(e3,"jls");
        map.put(e2,"shanu");
        map.put(e2,"mitu");

         StudentResult newStd = new StudentResult(1, 60);

        System.out.println(map.toString());
        Assert.assertEquals("mitansh",map.get(newStd));
    }
}
