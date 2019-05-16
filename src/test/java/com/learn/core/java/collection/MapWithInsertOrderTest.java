package com.learn.core.java.collection;

import com.learn.core.java.string.WordsInOrderOfLength;
import org.junit.Assert;
import org.junit.Test;


public class MapWithInsertOrderTest {

    @Test
    public void testMethod() {

        Assert.assertEquals("is not This good", WordsInOrderOfLength.solution1("This is not good"));
        Assert.assertEquals("This", WordsInOrderOfLength.solution1("This"));
        Assert.assertEquals("T", WordsInOrderOfLength.solution1("T"));
        Assert.assertEquals("Hello Mister", WordsInOrderOfLength.solution1("Hello Mister    "));
        Assert.assertEquals("S Hello Mister", WordsInOrderOfLength.solution1("Hello Mister    S"));
        Assert.assertEquals("", WordsInOrderOfLength.solution1(""));
    }
}
