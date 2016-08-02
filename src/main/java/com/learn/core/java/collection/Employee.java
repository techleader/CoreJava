package com.learn.core.java.collection;

import java.util.Comparator;
import java.util.EmptyStackException;

/**
 * Created by Meetansh on 13-07-2016.
 */
public class Employee implements Comparable<Employee> {
    String name;
    int salary;


    public int compareTo(Employee e) {
        Employee employee = (Employee) e;
        if (this.salary == e.salary) {
            return 0;
        } else if (this.salary > e.salary) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString(){
        return "Name: "+this.name+"-- Salary: "+this.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



}
