package com.learn.core.java.collection;

import java.util.*;

/**
 * Created by Meetansh on 13-07-2016.
 */
public class TreeSetTest {


    public static void main(String arg[]){

        Set<Employee> set = new TreeSet<>();


        Employee e1=new Employee();
        Employee e2=new Employee();
        Employee e3=new Employee();
        Employee e4=new Employee();



        Comparator<Employee> salaryComp = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getSalary() - e2.getSalary();
            }
        };

        Comparator<Employee> anmeComp = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
               return  e1.getName().compareTo(e2.getName());
            }
        };


       //TreeSet<Employee> list=new TreeSet<>();

       ArrayList<Employee> list=new ArrayList<>();
        e1.setName("raj");
        e1.setSalary(1000);
        e2.setName("jls");
        e2.setSalary(30000);
        e3.setName("monu");
        e3.setSalary(2000);
        e4.setName("Meetansh");
        e4.setSalary(30000);







        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        Collections.sort(list,anmeComp);
        Collections.unmodifiableList(list);

        for(Employee e:list){
            System.out.println(e + ", ");
        }
        Collections.sort(list,salaryComp);
        for(Employee e:list){
            System.out.println(e);
        }


       /* Iterator<Employee> iterator=list.iterator();
        while (iterator.hasNext()){
        //    System.out.println("name: "+iterator.next().getName()+", Salary: "+iterator.next().getSalary());

        }*/
    }


}
