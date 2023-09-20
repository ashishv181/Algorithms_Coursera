import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{
	
	private Node first;
	private int size;
	private int randomNumber;
	
	private class Node{
		Item item;
		Node next;
	}
	
	// construct an empty randomized queue
    public RandomizedQueue() {
    	first = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return first == null;
    }

    // return the number of items on the randomized queue
    public int size() {
    	return this.size;
    }

    // add the item
    public void enqueue(Item item) {
    	if(isEmpty()) {
        	first = new Node();
        	first.item = item;
    	} else {
        	Node currentNode = first;
        	while (currentNode.next != null) {
        		currentNode = currentNode.next;
        	}
        	Node newNode = new Node();
        	newNode.item = item;
        	currentNode.next = newNode;
    	}
    	size++;
    }

    // remove and return a random item
    public Item dequeue() {
    	int randomNo = StdRandom.uniformInt(size);
    	System.out.print("Number: " + randomNo + ", size: " + size);
    	Node currentNode = first;
    	Node prevNode = currentNode;
    	while(randomNo > 0) {
    		randomNo--;
    		prevNode = currentNode;
    		currentNode = currentNode.next;
    	}
    	Item item = currentNode.item;
    	prevNode.next = currentNode.next;
    	currentNode.next = null;
    	size--;
    	System.out.println(", item : " + item);
    	return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	int randomNo = StdRandom.uniformInt(size);
    	Node currentNode = first;
    	while(randomNo > 0) {
    		randomNo--;
    		currentNode = currentNode.next;
    	}
    	Item item = currentNode.item;
    	return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    	return new Iterator<Item>() {
    		Node currentNode = first;
    		@Override
    		public boolean hasNext() {
    			return currentNode != null;
    		}
    		@Override
    		public Item next() {
    			Item item = currentNode.item;
    			currentNode = currentNode.next;
    			return item;
    		}
		};
    }

    // unit testing (required)
    public static void main(String[] args) {
    	RandomizedQueue<Integer> deque = new RandomizedQueue<>();
    	deque.enqueue(15);
    	deque.enqueue(10);
    	deque.enqueue(5);
    	deque.enqueue(20);
    	deque.enqueue(25);
    	deque.enqueue(30);
     	
    	for(Integer i : deque) {
    		System.out.print(i + " | ");
    	}
    	System.out.println();
    	
    	deque.dequeue();
    	for(Integer i : deque) {
    		System.out.print(i + " | ");
    	}
    	System.out.println();
    	
    	deque.dequeue();
    	for(Integer i : deque) {
    		System.out.print(i + " | ");
    	}
    	System.out.println();
    	
    	deque.dequeue();
    	for(Integer i : deque) {
    		System.out.print(i + " | ");
    	}
    	System.out.println();
    	
    	deque.dequeue();
    	for(Integer i : deque) {
    		System.out.print(i + " | ");
    	}
    	System.out.println();
    }
}
