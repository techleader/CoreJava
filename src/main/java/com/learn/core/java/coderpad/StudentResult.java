package com.learn.core.java.coderpad;

import java.util.Objects;

public class StudentResult {
    int rollNo;
    int marks;

    public StudentResult(int rollNo, int marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "StudentResult{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        StudentResult that = (StudentResult) o;
        if (this == that) return true;
        if(that==null ||  getClass()!= that.getClass()) return false;

        if (rollNo != 0? rollNo!=that.rollNo: that.rollNo != 0 ) {
            return false;
        }

        if(rollNo==that.rollNo)return true;
        if (marks != 0? marks!= that.marks : that.marks != 0  ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, marks);
    }
}
