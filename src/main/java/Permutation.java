import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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

		// add all elements to a randomized queue and then call sample
		// have a number of element you enter
		int number = Integer.parseInt(args[0]);
		RandomizedQueue<String> littleQueue = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			littleQueue.enqueue(item);
		}
		for (int i = 0; i < number; i++) {
			StdOut.printf("%s \n", littleQueue.dequeue());
		}
	}
}
