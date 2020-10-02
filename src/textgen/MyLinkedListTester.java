/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
		
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check "+ " element", (Integer)65, list1.get(0));
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals("Remove: check size is correct ",(Integer)21, list1.head.next.data);
		assertEquals("Remove: check size is correct ",(Integer)42, list1.tail.prev.data);
		// TODO: Add more tests here
       
		try {
			list1.remove(-1);
			fail("index out of bound");
			}
	catch(IndexOutOfBoundsException e) {
				
			}
		try {
			list1.remove(LONG_LIST_LENGTH);
			fail("index out of bound");
			}
	catch(IndexOutOfBoundsException e) {
				
			}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		emptyList.add(5);
		emptyList.add(7);
		emptyList.add(9);
		try {
			emptyList.add(null);
			fail("check null pointer exception");
		}
		catch(NullPointerException e) {
			
		}
		assertEquals("Remove: check size is correct ", 3, emptyList.size());
		assertEquals("Remove: check size is correct ", (Integer)7, emptyList.head.next.next.data);
		assertEquals("Remove: check size is correct ", (Integer)5, emptyList.head.next.next.prev.data);
		assertEquals("Remove: check size is correct ", (Integer)9, emptyList.tail.prev.data);
		assertEquals("Remove: check size is correct ", (Integer)7, emptyList.get(1));
		assertEquals("Remove: check size is correct ", (Integer)7, emptyList.remove(1));
		try {
			emptyList.add(-1,4);;
			fail("index out of bound");
			}
	catch(IndexOutOfBoundsException e) {
				
			}
		try {
			emptyList.add(LONG_LIST_LENGTH,4);;
			fail("index out of bound");
			}
	catch(IndexOutOfBoundsException e) {
				
			}
		
		try {
			emptyList.add(1,null);;
			fail("null pointer exception");
			}
	catch(NullPointerException e) {
				
			}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		emptyList.add(5);
		emptyList.add(7);
		emptyList.add(9);
		
		assertEquals("check size is correct ", 3, emptyList.size());
		emptyList.remove(1);
		assertEquals("check size is correct ", 2, emptyList.size());
		assertEquals("check size is correct ", (Integer)9, emptyList.get(1));
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
		list1.add(-1,58);
		fail("index out of bound");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
		list1.add(1,null);
		fail("null point exception");
		}
         catch(NullPointerException e) {
			
		}
		list1.add(2,66);
		assertEquals("check size is correct ", (Integer)42, list1.get(3));
		assertEquals("check size is correct ", 4, list1.size);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
		list1.set(1, null);
		fail("null point exception");
		}
         catch(NullPointerException e) {
			
		}
		try {
		list1.set(LONG_LIST_LENGTH, 73);
		fail("index out of bound");
		}
catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(-1, 73);
			fail("index out of bound");
			}
	catch(IndexOutOfBoundsException e) {
				
			}
		
		list1.set(1, 46);
		assertEquals("check element is correct ", (Integer)46, list1.get(1));
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
