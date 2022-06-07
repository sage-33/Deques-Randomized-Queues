import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 * Name: Kevin Wayne Login: wayne Precept: P02
 *
 * Partner Name: N/A Partner Login: N/A Partner Precept: N/A
 * 
 * Compilation: javac-algs4 Permutation.java Execution: java-algs4 Permutation k
 * < <filename> Dependencies: RandomizedQueue.java StdIn.java StdOut.java
 *
 * Description: Takes an integer k as a command-line argument; reads in a
 * sequence of strings from standard input using StdIn.readString(); and prints
 * exactly k of them, uniformly at random. Prints each item from the sequence at
 * most once.
 ******************************************************************************/

/**
 * @author sagesilberman
 * 
 *         A {@link Permutation} represents a program which iterates through
 *         items from a text file and randomly returns k number of them in a
 *         random order
 */
public class Permutation {
	public static void main(String[] args) {
		int numToAdd = Integer.parseInt(args[0]);
		int addedCount = 0;
		int junked = 0;
		RandomizedQueue<String> littleQueue = new RandomizedQueue<String>();
		if (numToAdd > 0) {
			while (!StdIn.isEmpty()) {
				String item = StdIn.readString();
				if (addedCount == numToAdd) {
					if (StdRandom.uniform(0, junked + numToAdd + 1) < numToAdd) {
						littleQueue.dequeue();
						littleQueue.enqueue(item);
					}
					junked++;
				} else {
					littleQueue.enqueue(item);
					addedCount++;
				}

			}
			for (int i = 0; i < numToAdd; i++) {
				StdOut.printf("%s \n", littleQueue.dequeue());
			}
		}
	}
}