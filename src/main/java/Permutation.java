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
public class Permutation {
	public static void main(String[] args) {
		int numToAdd = Integer.parseInt(args[0]);
		int addedCount = 0;
		RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			// always add the first k items
			if (addedCount == numToAdd) {
				// then flip a coin, so 50/50 chance that we dequeue an item already // added,
				// and
				// enqueue another
				// because the dequeue is random then the order should be random
				if (StdRandom.uniform(0, 2) == 0) {
					randomQueue.dequeue();
					randomQueue.enqueue(item);
				}
			} else {
				randomQueue.enqueue(item);
				addedCount++;
			}

		}
		for (int i = 0; i < numToAdd; i++) {
			StdOut.printf("%s \n", randomQueue.dequeue());
		}
	}

}
