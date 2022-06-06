
/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 * 
 *  Compilation:  javac-algs4 Deque.java
 *  Execution:    java-algs4 Deque
 *  Dependencies: Item.java Iterator.java
 *
 *  Description:  Implementing a Deque using linked structures
 ******************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author sagesilberman
 * 
 *         Represents a program which directs the addition and removal of items
 *         from a list
 * 
 * @param <Item> is the item to be added or removed from the list
 */
public class Deque<Item> implements Iterable<Item> {
	private int count = 0; // variable to keep track of the size
	private Node first, last; // create a node

	/**
	 * Creates an empty deque
	 */
	public Deque() {
		first = null;
		last = null;
	}

	/**
	 * Represents the creation of two nodes, a prev and next, and an item
	 *
	 */
	private class Node {
		Node prev; // previous node
		Item item; // item
		Node next; // next node
	}

	/**
	 * Returns <code>true</code> if the first and last element of the list are null
	 * 
	 * @return <code>true</code> if the first and last element of the list are null
	 */
	public boolean isEmpty() {
		return (first == null && last == null);

	}

	/**
	 * Returns the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return count;
	}

	/**
	 * Adds an element to the front of the list and increases the count variable
	 * keeping track of the size
	 * 
	 * @param item is the element to be added to the front of the list
	 */
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item is null");
		}
		Node ogFirst = first;
		first = new Node();

		first.item = item; // reset item
		first.next = ogFirst; // reset next
		first.prev = null; // reset null

		if (ogFirst != null) {
			ogFirst.prev = first;
		}
		if (last == null) {
			last = first;
		}

		count++;

	}

	/**
	 * Adds an element to the end of the list and increases the count variable
	 * keeping track of the size
	 * 
	 * @param item is the element to be added to the end of the list
	 */
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item is null");
		}
		Node ogLast = last;
		last = new Node();

		last.item = item; // reset item
		last.next = null; // reset next
		last.prev = ogLast; // reset null

		if (ogLast != null) {
			ogLast.next = last;
		}
		if (first == null) {
			first = last;
		}

		count++;

	}

	/**
	 * Removes an element from the front of the list and decreases the count
	 * variable keeping track of the size
	 * 
	 * @return the element removed from the front of the list
	 */
	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("it's empty so can't execute code");
		}
		Item back = first.item;
		count--;

		if (first.equals(last)) {
			first = null;
			last = null;
		} else {
			first = first.next;
			first.prev = null;
		}
		return back;
	}

	/**
	 * Removes an element from the end of the list and decreases the count variable
	 * keeping track of the size
	 * 
	 * @return the element removed from the end of the list
	 */
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("it's empty so can't execute code");
		}
		Item back = last.item;
		count--;

		if (first.equals(last)) {
			first = null;
			last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		return back;
	}

	/**
	 * Creates a new ListIterator
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * Represents an iterator which allows the traversal through the list of items
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException("no elements left");
			Item elem = current.item;
			current = current.next;
			return elem;
		}

		/**
		 * Prevents unspecified removal of an item
		 */
		public void remove() {
			throw new UnsupportedOperationException("opperation is unsupported");
		}
	}

	public static void main(String[] args) {
		// unit testing (optional)
	}
}