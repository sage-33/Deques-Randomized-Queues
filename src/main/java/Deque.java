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

public class Deque<Item> implements Iterable<Item> {

  public Deque() {
    // construct an empty deque
  }

  public boolean isEmpty() {
    // is the deque empty?
    return false;
  }
  
  public int size() {
    // return the number of items on the deque
    return 0;
  }
  
  public void addFirst(Item item) {
    // add the item to the front
  }
  
  public void addLast(Item item) {
    // add the item to the end
  }
  
  public Item removeFirst() {
    // remove and return the item from the front
    return null;
  }
  
  public Item removeLast() {
    // remove and return the item from the end
    return null;
  }
  public Iterator<Item> iterator() {
    // return an iterator over items in order from front to end
    return null;
  }
  public static void main(String[] args) {
    // unit testing (optional)
  }
}