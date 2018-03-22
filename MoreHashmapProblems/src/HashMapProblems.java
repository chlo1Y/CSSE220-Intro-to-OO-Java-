import java.util.HashMap;


public class HashMapProblems {

	/* This function takes a HashMap of Strings to integers.  It increases the value of
	 * each integer by one.
	 * 
	 * For example:
	 * 
	 * {ab=1, xyz=5, cd=10} becomes {ab=2, xyz=6, cd=11}
	 * 
	 */
	public static void increaseHashmapValues(HashMap<String,Integer> input) {
		return;
	}
	
	/* We will consider a smaller hashmap a "subset" of a bigger hashmap if:
	 *  every key in the smaller hashmap is in the bigger hashmap
	 *  and the values at the keys are the same in both hashmaps
	 * 
	 * So {ab = x} is a subset of {qqq = y, ab = x}
	 *    {ab = x} is a subset of {ab = x}
	 *    {ab = x} is a NOT subset of {qqq = y, ab = y} (values are different)
	 *    {v = v, ab = x} is a NOT subset of {v =v, qqq = y, q = y} (missing key ab)
	 *    {qqq = y, ab = x} is NOT a subset of {ab = x} (missing key qqq)
	 *    
	 *  Write a function that takes a smaller and bigger hashmap and determines
	 *  if the smaller is a subset of the bigger
	 */
	public static boolean isSubset(HashMap<String,String> smaller, HashMap<String,String> bigger) {
		return false;
	}
	
	/* Returns the first missing even key value in the hashmap.  2 is considered the 
	 * first even number for the purposes of this function.
	 * 
	 * For example:
	 * For the map {2="x",4="y"} the function returns 6
	 * For the map {1="abc",3="efg",100="blah"} the function returns 2
	 *  
	 */
	public static int firstMissingEven(HashMap<Integer,String> map) {
		return 0;
	}
}
	