
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

public class RandomizedQueue<Item> implements Iterable<Item> {
	private int count; // // indicates number of elements stored
	private Item[] arr; // the array
	private final Item[] randomized; // the array

	// done: construct an empty randomized queue
	public RandomizedQueue() {
		arr = (Item[]) new Object[1];
		randomized = arr;
		StdRandom.shuffle(randomized);
	}

	// done: is the randomized queue empty?
	public boolean isEmpty() {
		return count == 0;
	}

	// done: return the number of items on the randomized queue
	public int size() {
		return count;
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("you need to enter an item!");
		}
		if (count == arr.length) {
			resize(2 * arr.length);
		}
		arr[count++] = item;
	}

	// remove and return a random item
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("no elements inside the array");
		}
		int random = StdRandom.uniform(count);
		if (!(count == 1 || count - 1 == random)) {
			swap(random);
		}
		Item item = arr[--count];
		arr[count] = null;
		if (count > 1 && count == arr.length / 4)
			resize(arr.length / 2);
		return item;
	}

	// done: return a random item (but do not remove it)
	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("no elements inside the array");
		}
		int random = StdRandom.uniform(count);
		return arr[random];
	}

	// private
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < count; i++)
			copy[i] = arr[i];
		arr = copy;
	}

	// private
	private void swap(int x) {
		Item txt;
		txt = arr[x];
		arr[x] = arr[count - 1];
		arr[count - 1] = txt;
	}

	// done: return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// private
	private class ListIterator implements Iterator<Item> {
		private int current;
		private final Item[] shuffledArr;

		public ListIterator() {
			current = count;
			shuffledArr = arr;
		}

		public boolean hasNext() {
			return current > 0;
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("it's empty so can't execute code");
			}
			return shuffledArr[--current];

		}

		public void remove() {
			throw new UnsupportedOperationException("opperation is unsupported");
		}
	}

	public static void main(String[] args) {
		// unit testing (optional)

	}
}