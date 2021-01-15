package com.learn.core.java.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class Tries {

	private Node root;

	public Tries() {
		root = new Node('*', false, 1);
	}

	public boolean match(String value) {
		return match(root, value);
	}
	
	private boolean match(Node root, String value) {		
		boolean match = false;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			root = match(root, c);
			if (root == null) {
				break;
			}

		}
		if (root != null && root.isCompleted) {
			match = true;
		}
		return match;
	}

	public Node match(Node root, char value) {
		for (Node child : root.childs) {
			if (child != null) {
				if (child.digit == value) {
					return child;
				}
			}
		}
		return null;
	}

	public void addNode(String value) {
		Node triesRoot = root;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			triesRoot = addNode(triesRoot, c, i == value.length() - 1);
		}

	}

	public Node addNode(Node root, char digit, boolean isCompleted) {
		for (Node child : root.childs) {
			if (child != null) {
				if (child.digit == digit) {
					return child;
				}
			}
		}

		Node child = new Node(digit, isCompleted, root.level + 1);
		root.childs.add(child);
		return child;
	}

	public void print() {
		print(root);
	}

	public void print(Node root) {
		int n = 2*root.level;
		if(root.isCompleted) {
			String space = (n> 0) ? String.format("%0" + n + "d", 0).replace("0", " ") : "";
			System.out.println("\n" + space + root.digit);
		} else {
			System.out.print("->" + root.digit );
		}
		
		for (Node child : root.childs) {
			print(child);
		}
	}

	static class Node {
		private char digit;
		private ArrayList<Node> childs;
		private boolean isCompleted;
		private int level;

		public Node(char digit, boolean isCompleted, int level) {
			this.digit = digit;
			this.isCompleted = isCompleted;
			this.level = level;
			childs = new ArrayList<Node>();
		}

	}

	

}
