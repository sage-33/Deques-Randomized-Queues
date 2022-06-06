import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RandomizedQueueTest {

	private RandomizedQueue<String> list;

	@Before
	public void setUp() throws Exception {
		list = new RandomizedQueue<String>();
	}

	@Test
	public void testIsEmpty() {
		ArrayList<String> expectedResult = new ArrayList<String>();
		assertTrue(list.isEmpty());
		expectedResult.add("Hello");
		list.enqueue("Hello");
		String actualResult = list.dequeue();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testSize() {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Hello");
		assertEquals(1, expectedResult.size());
		expectedResult.add("World");
		assertEquals(2, expectedResult.size());
		assertTrue(list.size() == 0);
		list.enqueue("hello world");
		assertTrue(list.size() == 1);
		list.dequeue();
		assertTrue(list.size() == 0);
	}

	@Test
	public void testEnqueue() {
		list.enqueue("One");
		assertEquals(1, list.size());
		list.enqueue("Two");
		assertEquals(2, list.size());
		list.enqueue("Three");
		assertEquals(3, list.size());
		list.enqueue("Four");
		assertEquals(4, list.size());
	}

	@Test
	public void testDequeue() {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Hello");
		expectedResult.add("World");
		list.enqueue("Hello");
		list.enqueue("World");
		String actualResult = list.dequeue();
		assertTrue("Should contain " + actualResult, expectedResult.contains(actualResult));
		expectedResult.remove(actualResult);
		actualResult = list.dequeue();
		assertTrue("Should contain the other word " + actualResult, expectedResult.contains(actualResult));
	}

	@Test
	public void testSample() {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Hello");
		expectedResult.add("World");
		list.enqueue("Hello");
		list.enqueue("World");
		String actualResult = list.sample();
	}

	@Test
	public void testIterator() {
		ArrayList<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Hello");
		expectedResult.add("World");
	}

}
