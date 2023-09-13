package week2.Stacks;

import java.util.function.Predicate;

/**
 * This class gives a linked list implementation for the Stack
 * This operates in constant time but has greater wastage as compared to the resizeable array stack
 *
 */
public class MyStringLinkedListStack {
	
	private Predicate<Node> checkIsEmpty = node -> {
		if(node == null) {
			System.out.println("List is Empty");
			return true;
		}
		return false;
	};
	private Node first = null;
	
	private class Node{
		Node next;
		String item;
	}
	
	public boolean isEmpty() {
		return checkIsEmpty.test(first);
	}
	
	public void push(String input) {
		// point to the first node object in the list with a new variable
		Node oldFirst = first;	
		//insert the pushed item in a new node and point to it with the first node variable
		first = new Node();
		first.item = input;
		
		//Now link the new node to the old node such that the each new node becomes the new first node
		first.next = oldFirst;
	}
	
	public void pop() {
		first = first.next;
	}
	
	public void printStack() {
		Node current = first;
		
		while(current != null) {
			System.err.print(current.item + " -> ");
			current = current.next;
		}
		System.out.println("\n");
	}
	
	public String get() {
		return first.item;
	}

}
