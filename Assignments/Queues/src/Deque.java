import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Deque<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int size;
	
	private class Node{
		Item item;
		Node prev;
		Node next;
	}

    // construct an empty deque
    public Deque() {
    	first = null;
    	last = first;
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return first == null && last == null;
    }

    // return the number of items on the deque
    public int size() {
    	return this.size;
    }
    
    // add the item to the front
    public void addFirst(Item item) {
    	if(isEmpty()) {
    		first = new Node();
    		first.item = item;
    		last = first;
    	}else {
    		Node oldFirst = first;
        	first = new Node();
        	first.item = item;
        	first.next = oldFirst;
        	oldFirst.prev = first;
    	}
    	size++;
    }

    // add the item to the back
    public void addLast(Item item) {
    	if(isEmpty()) {
    		last = new Node();
    		last.item = item;
    		first = last;
    	}else {
    		Node oldLast = last;
    		last = new Node();
    		last.item = item;
    		oldLast.next = last;
    		last.prev = oldLast;
    	}
    	size++;
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
    	Item item = first.item;
    	if(first == last) {
    		first = null;
    		last = first;
    	} else {
        	first = first.next;
        	first.prev = null;
    	}
    	size--;
    	return item;
    }
    
    // remove and return the item from the back
    public Item removeLast() {
    	Item item = last.item;
    	if(first == last) {
    		last = null;
    		first = last;
    	} else {
        	last = last.prev;
        	last.next = null;
    	}
    	size--;
    	return item;
    }
    

    // return an iterator over items in order from front to back
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
    	Deque<Integer> deque = new Deque<>();
    	deque.addFirst(15);
    	deque.addFirst(10);
    	deque.addFirst(5);
    	deque.addLast(20);
    	deque.addLast(25);
    	deque.addLast(30);
     	
    	Iterator<Integer>  itr = deque.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " | ");
    	}
    	System.out.println();
    	
//    	deque.removeFirst();
    	deque.removeLast();
    	for(Integer i : deque) {
    		System.out.print(i + " | ");
    	}
    	System.out.println();
    	
//    	deque.removeFirst();
    	deque.removeLast();    	itr = deque.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " | ");
    	}
    	System.out.println();
    	
//    	deque.removeFirst();
    	deque.removeLast();    	itr = deque.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " | ");
    	}
    	System.out.println();
    	
//    	deque.removeFirst();
    	deque.removeLast();    	itr = deque.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " | ");
    	}
    	System.out.println();
    	
//    	deque.removeFirst();
    	deque.removeLast();    	itr = deque.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " | ");
    	}
    	System.out.println();
    	
//    	deque.removeFirst();
    	deque.removeLast();    	itr = deque.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next() + " | ");
    	}
    	System.out.println();
    }
   
}