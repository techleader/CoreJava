package com.learn.core.java.linkedlist;

/**
 * Created by Admin on 05-08-2016.
 */
public class LinkedListUtil {

	public static Node linkedList(int... no) {
		if (no == null || no.length == 0)
			return null;
		Node head = null;
		Node current = null;
		for (int x : no) {
			Node n = new Node(x);
			if (head == null) {
				head = n;
				current = n;
			} else {
				current.next = n;
				current = current.next;
			}
		}
		return head;
	}

	public static Node reverse(Node root) {
		Node current = root;
		Node last = null;
		while (current != null) {
			Node temp = current.next;			
			current.next = last;
			last = current;			
			current = temp;
		}
		return last;
	}
	
	public static Node findMiddle(Node root) {
		if(root == null || root.next==null) return null;
		Node head1, head2;
		head1 = head2 = root;
		while (head1!=null && head1.next != null) {
			head1 =  head1.next.next;				
			head2 = head2.next;
		}
		return head2;
	}

	
	public static int size(Node list) {
		int size = 0;
		while (list != null) {
			size++;
			list = list.next;
		}
		return size;

	}

	public static void print(Node head) {
		print(head, ", ");
	}

	public static void print(Node head, String sep) {
		System.out.println();
		while (head != null) {
			System.out.print(head.data + sep);
			head = head.next;
		}
	}

}
