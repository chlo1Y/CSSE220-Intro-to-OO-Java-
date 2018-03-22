import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


public class HashMapProblemsTest {

	@Test
	public void testIncreaseHashmapValues() {
		HashMap<String,Integer> test1 = new HashMap<String,Integer>();
		test1.put("ab", 1);
		test1.put("cd", 10);
		test1.put("xyz", 5);
		HashMapProblems.increaseHashmapValues(test1);
		assertEquals(2, (int) test1.get("ab"));
		assertEquals(11, (int) test1.get("cd"));
		assertEquals(6, (int) test1.get("xyz"));

		HashMap<String,Integer> test2 = new HashMap<String,Integer>();
		test2.put("hello", -1);
		test2.put("goodbye", 0);
		test2.put("xyz", 5);
		HashMapProblems.increaseHashmapValues(test2);
		assertEquals(0, (int) test2.get("hello"));
		assertEquals(1, (int) test2.get("goodbye"));
		assertEquals(6, (int) test2.get("xyz"));

		
	}
	
	@Test
	public void testIsSubset() {
		HashMap<String,String> test1 = new HashMap<String,String>();
		test1.put("ab", "a");
		
		HashMap<String,String> test2 = new HashMap<String,String>();
		test2.put("ab", "a");
		test2.put("other", "x");
		
		assertTrue(HashMapProblems.isSubset(test1, test2));
		test1.put("ab", "not matched");
		assertFalse(HashMapProblems.isSubset(test1, test2));
		test1.put("ab", "a");
		test1.put("new", "new");
		assertFalse(HashMapProblems.isSubset(test1, test2));
		test2.put("new", "new");
		assertTrue(HashMapProblems.isSubset(test1, test2));
		assertFalse(HashMapProblems.isSubset(test2, test1));		
	}
	
	@Test
	public void testMissingEven() {
		HashMap<Integer,String> test1 = new HashMap<Integer,String>();
		assertEquals(2, HashMapProblems.firstMissingEven(test1));
		test1.put(1,"qqq");
		assertEquals(2, HashMapProblems.firstMissingEven(test1));
		test1.put(2,"qqq");
		assertEquals(4, HashMapProblems.firstMissingEven(test1));
		test1.put(4, "q");
		test1.put(6, "q");
		test1.put(10, "q");
		assertEquals(8, HashMapProblems.firstMissingEven(test1));
		test1 = new HashMap<Integer,String>();
		for(int i = 1; i < 10000; i++) {
			test1.put(2*i, "even");
		}
		assertEquals(20000, HashMapProblems.firstMissingEven(test1));
		
	}

}
