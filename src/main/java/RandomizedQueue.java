
/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 * 
 *  Compilation:  javac-algs4 RandomizedQueue.java
 *  Execution:    java-algs4 RandomizedQueue
 *  Dependencies: Item.java Iterator.java
 *
 *  Description:  Implementing a Queue that chooses elements at random using an array
 ******************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author sagesilberman
 * 
 *         Represents a program which directs the random addition or removal of
 *         items from a list
 * 
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private int count; // // indicates number of elements stored
	private Item[] arr; // the array
	private final Item[] randomized; // the array

	/**
	 * Constructs an empty randomized queue
	 */
	public RandomizedQueue() {
		arr = (Item[]) new Object[1];
		randomized = arr;
		StdRandom.shuffle(randomized);
	}

	/**
	 * If the size of the list is 0, return <code>true</code>
	 * 
	 * @return <code>true</code> if the size of the list is 0
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the number of items in the randomized queue
	 * 
	 * @return the number of items in the randomized queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Adds an item to the list by resizing the array length and adding the item to
	 * the end
	 * 
	 * @param item is the element added to the end of the list
	 */
	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("you need to enter an item!");
		}
		if (count == arr.length) {
			resize(2 * arr.length);
		}
		arr[count++] = item;
	}

	/**
	 * Removes and returns a random item from the list
	 * 
	 * @return the random removed item
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("no elements inside the array");
		}
		int random = StdRandom.uniform(count);
		Item item = arr[random];
		arr[random] = arr[count - 1];
		count--;
		// shrink size of array if necessary
		if (count > 0 && count == arr.length / 4)
			resize(arr.length / 2);
		return item;
	}

	/**
	 * Returns a random item from the list
	 * 
	 * @return the random item
	 */
	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("no elements inside the array");
		}
		int random = StdRandom.uniform(count);
		return arr[random];
	}

	/**
	 * Alters the size of the array by creating a copy of the array with the number
	 * of indexes specified in capacity
	 * 
	 * @param capacity is the number of indexes the new array will have
	 */
	private void resize(int capacity) {
		assert capacity >= count;
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < count; i++)
			copy[i] = arr[i];
		arr = copy;
	}

	/**
	 * Returns an iterator over items in random order
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * Represents an iterator which allows the traversal through the list of items
	 */
	private class ListIterator implements Iterator<Item> {
		private int current; // the current size of the array
		private final int[] shuffledArr = new int[count];; // maintains the randomized order of the array

		/**
		 * Constructs an Iterator containing an array
		 */
		public ListIterator() {
			current = count;
			for (int i = 0; i < count; i++) {
				shuffledArr[i] = i;
			}
			StdRandom.shuffle(shuffledArr);
		}

		@Override
		public boolean hasNext() {
			return current < count;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("it's empty so can't execute code");
			}
			return arr[shuffledArr[current++]];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("opperation is unsupported");
		}

	}

	public static void main(String[] args) {
// unit testing (optional)

	}
}
