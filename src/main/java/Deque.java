
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

public class Deque<Item> implements Iterable<Item> {
	private int count = 0; // variiable to keep track of the count
	private Node first, last; // create a node

	// done
	public Deque() {
		first = null;
		last = null;
	}

	// done
	private class Node {
		Node prev; // previous node
		Item item; // item
		Node next; // next node
	}

	// done: is the deque empty?
	public boolean isEmpty() {
		return (first == null && last == null);

	}

	// done: return the number of items on the deque
	public int size() {
		return count;
	}

	// done: add the item to the front
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

	// done: add the item to the end
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

	// done: remove and return the item from the front
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

	// done: remove and return the item from the end
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

	// done: return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

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

		// done
		public void remove() {
			throw new UnsupportedOperationException("opperation is unsupported");
		}
	}

	public static void main(String[] args) {
		// unit testing (optional)
	}
}