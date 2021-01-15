package com.learn.core.java.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Created by Meetansh on 28-07-2016.
 */



public class LinkedListTest {
	
	@Test
	public void testFindMiddle() {
		Node root = LinkedListUtil.linkedList(new int[] {1,2,3,4,5});
		Node val = LinkedListUtil.findMiddle(root);
		assertEquals(3, val.data);
		root = LinkedListUtil.linkedList(new int[] {1,2,3,4});
		val = LinkedListUtil.findMiddle(root);
		assertEquals(3, val.data);
		root = LinkedListUtil.linkedList(new int[] {1});
		val = LinkedListUtil.findMiddle(root);
		assertNull(val);
	}
	
	@Test
	public void testReverse() {
		Node root = LinkedListUtil.linkedList(new int[] {1,2,3,4,5});
		LinkedListUtil.print(root);
		root = LinkedListUtil.reverse(root);
		LinkedListUtil.print(root);
		assertEquals(5, root.data);
	}
	
}
