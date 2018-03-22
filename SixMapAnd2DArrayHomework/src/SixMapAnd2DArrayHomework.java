import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 * MOST OF THESE PROBLEMS SHOULD BE DONE INDIVIDUALLY
 * One of them you can do with a partner 
 * 
 * Some practice problems with 2d arrays and hashmaps
 * Actually includes 6 regular problems and one bonus problem
 *
 * @author hewner.
 *         Created Dec 31, 2013.
 */
public class SixMapAnd2DArrayHomework {
	
	/**
	 * Given one string, return the most common character.
	 * 
	 * Example:
	 *   mostCommonCharacter("aaab") returns 'a'
	 *   mostCommonCharacter("abcbcdc") returns 'c'
	 * 
	 * You can assume that your string will not be empty and that
	 * one character will be more common than all the others (i.e. there
	 * won't be a tie for the most common character)
	 * 
	 * Your solution should use hashmaps, NOT nested for loops.
	 * You'll need one for loop though.
	 *
	 * @param input - string to find most common character of
	 * @return most common character
	 * 
	 */
	public static char mostCommonCharacter(String input) {
		int value=0;
		char result=' ';
		HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
		for(int i=0; i<input.length();i++){
			if(myMap.containsKey(input.charAt(i))==false){
				myMap.put(input.charAt(i), 1);
			}
			else{
				myMap.put(input.charAt(i), myMap.get(input.charAt(i))+1);
			}
			if(myMap.get(input.charAt(i))>value){
				value=myMap.get(input.charAt(i));
				result=input.charAt(i);
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * Reverses (i.e. exchanges the keys and values) a hashmap which 
	 * may contain multiple keys with the same value.  Because of this,
	 * the values of the reversed map will be a list.
	 * 
	 * 
	 * For example:
	 * {1=A,2=A,3=B} yields {A=[1,2], B=[3]}
	 * 
	 * The initial hashmap maps Integers to Strings.
	 * The reversed hashmap will map Strings to ArrayLists of Integers/
	 * 
	 * @param initialMap the HashMap to be reversed
	 * @return a copy of the hashmap with keys and values exchanged
	 */
	public static HashMap<String,ArrayList<Integer>> reverseHashmap(HashMap<Integer,String> initialMap) {
		HashMap<String, ArrayList<Integer>> myMap= new HashMap<String, ArrayList<Integer>>();
		Set<Integer> initialKeys= initialMap.keySet();
		for(int oneInitialKey:initialKeys){
			if(myMap.containsKey(initialMap.get(oneInitialKey))==true){
				myMap.get(initialMap.get(oneInitialKey)).add(oneInitialKey);
				
			}else{
				myMap.put(initialMap.get(oneInitialKey), new ArrayList<Integer>());
				myMap.get(initialMap.get(oneInitialKey)).add(oneInitialKey);
			}
		}
		return myMap;
	}
	
	/**
	 * In a particular school (not Rose-Hulman) each course can only have 1 pre-requisite course.
	 *  
	 * These pre-req courses are represented by a map, for example:
	 * 
	 * {"CS120"="","CS220"="CS120","CS230"="CS220","MA100"="MA102","MA102"="MA100"}
	 * 
	 * Note that if a course has no pre-req, it is represented by the empty string ""
	 * 
	 * So in this example, CS120 has no pre-req course.
	 *                     CS220 has a pre-req of 120
	 *                     CS230 has a pre-req of 230
	 *                     MA100 has a pre-req of MA102
	 *                     MA102 has a pre-req of MA100
	 *                     
	 * Your job is to write a function that determines how many courses must be taken to take a specific course.
	 * 
	 * So your function should return 0 for "CS120"
	 *    your function should return 1 for "CS220"
	 *    your function should return 2 for "CS230"
	 *    your function should return -1 for "MA102" or "MA100".  They are in a pre-req loop, so it is impossible to take any of the courses. 
	 * 
	 * @param courseMap map of all courses to a pre-req
	 * @param course course to check
	 * @return number of courses before you can take given course, or -1 if it is in a pre-req loop
	 */
	public static int getNumberOfCoursesToTake(HashMap<String,String> courseMap, String course) {
	
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		
		while (!result.containsKey("")){
			
			if (result.containsKey(courseMap.get(course))){
				return -1;
			}
			result.put(courseMap.get(course),0);
			course = courseMap.get(course);
		}
			
		return result.size()-1;
		
		
		
	}
	
	/**
	 * 
	 * Given a square array, determines if is diagonal
	 * That is, returns true if all values in the array are 0 
	 * except the main diagonal.  The main diagonal is entries of the form
	 * data[i][j] where i == j.  Elements on the main
	 * diagonal can be 0 or any other number.
	 * 
	 * Examples:
	 * {{1,0,0},
	 *  {0,2,0}
	 *  {0,0,3}} yields true
	 *  
	 * {{1,0,9},
	 *  {0,2,0},
	 *  {0,0,3}} yields false because 0,2 is nonzero
	 * 
	 * {{0,0,0},
	 *  {0,0,0},
	 *  {0,0,3}} yields true because there can be 0
	 *                  entries on the diagonal if desired
	 * @param data input array
	 * @return true if it is diagonal, false otherwise
	 */
	public static boolean isDiagonal(int[][] data) {
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[0].length;j++){
				if(i==j){
					data[i][j]=0;
				}
				if(data[i][j]!=0){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * Given a 2D array populated with a sequence of characters 
	 * that wrap from the rightmost position to the leftmost position 
	 * on the next row, find the length the longest sequence of repeated 
	 * characters. 
	 * 
	 * For example
	 * 
	 * abba
	 * dafa
	 * 
	 * Has a longest sequence of 2 for the 2 repeated
	 * bs
	 * 
	 * 2 Bs yield the longest repeat sequence here. Note that the As do not 
	 * follow after each other and hence, do not get considered.
	 * 
	 * The array is considered to "wrap" 
	 * from the rightmost position to the leftmost
	 * position on the next line.
	 * 
	 * For example:
	 * 
	 * abcdd
	 * ddefg
	 * 
	 * Is considered to have a longest sequence of 4
	 * because the two ds on the right "wrap around"
	 * to connect with the two ds on the next line 
	 * 
	 * @param data
	 * @return the length of the longest sequence
	 */
	public static int longestRepeatSequence(char[][] data) {
		String myS=" ";
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[0].length; j++){
			    myS=myS+data[i][j];
			}	
		}
		int timeRepeat=0;
		int counter=1;
		int max=0;
		for(int i=0; i<myS.length()-1;i++){
			if(myS.charAt(i)==myS.charAt(i+1)){
				counter=counter+1;
				timeRepeat=counter;
			}else{
				counter=0;
			}
			if(timeRepeat>max){
				max=timeRepeat;
			}
		}	
		return max+1;
	}
	
	
	/**
	 * Given A specific starting position and distance
	 * returns a 10x10 character array with all positions
	 * that are less than or equal to that manhattan distance 
	 * from the starting position marked with an x.
	 * 
	 * Recall the manhattan distance is the distance
	 * in terms of number of direct steps North South East West.
	 *
	 * You can compute the manhanttan distance with this formula
        * distance = |x1 - x2| + |y1 - y2|
	 * 
	 * Unmarked cells should be filled with a period '.'
	 * 
	 * For example, given row=1,col=1,distance 1
	 * .x........
	 * xxx.......
	 * .x........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * 
	 * For example, given row=1,col=6,distance 2
	 * .....xxx..
	 * ....xxxxx.
	 * .....xxx..
	 * ......x...
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........

	 * 
	 * @param row starting position row
	 * @param col starting position col
	 * @param distance
	 * @return new 10x10 char array with correct squares marked
	 */
	public static char[][] distanceArray(int row, int col, int distance) {
		char[][] myMap=new char[10][10];
		for(int i=0; i<10;i++){
			for(int j=0; j<10; j++){
				//myMap[row][col]='x';
				if(Math.abs(i-row)+Math.abs(j-col)<=distance){
					myMap[i][j]='x';
				}else{
					myMap[i][j]='.';
				}
			}
		}
		return myMap;
	}
	
	/**
	 * BONUS: Extra credit problem
	 * 
	 * Feel free to skip this one if you don't have time.
	 * It's a little harder.
	 * 
	 * You are given a map indicating the elevation of
	 * a small area like a desk.  A ball is placed on the desk.
	 * The ball will roll downhill going north south east or west.
	 *
	 * The ball always starts at position 1,1
	 *
	 * It will always choose the path of steepest descent.
	 * It will eventually come to rest when it is at a position
	 * where all neighboring positions are higher/equal.  
	 * Return the elevation of that position.
	 * 
	 * You can assume that map will be such that the ball
	 * will always come to rest without moving through an edge
	 * 
	 * You can assume there will always be one steepest
	 * position for the ball to go to
	 * 
	 * For example, in an array like this:
	 * 9999
	 * 9549
	 * 9999 yields 4
	 * The ball would start in 1,1 (5) rolls to 4 and stops
	 * 
	 * 99999999999
	 * 98711111199
	 * 96999999999
	 * 95444444399
	 * 99999999999 yields 4
	 * The ball starts at 8, follows steepest decent to 6
	 * Then at the first 4 there is no lower position so it
	 * stops
	 * 
	 * @param map map indicating elevation
	 * @return height where the ball stopsnew
	 */
	public static int ballRestElevation(int[][] map) {
		int currentX=1;
		int currentY=1;
		
		HashMap<String,int[]> myMap= new HashMap<String, int[]>();
		int[]arrayLeft = {currentX,currentY-1};
		int[] arrayRight= {currentX,currentY+1};
		int[] arrayCurrent={currentX,currentY};
		int[] arrayUp={currentX-1,currentY};
		int[] arrayDown={currentX+1,currentY};
		myMap.put("arrayLeftKey", arrayLeft);
		myMap.put("arrayRightKey",arrayRight );
		myMap.put("arrayCurrentKey",arrayCurrent );
		myMap.put("arrayUpKey",  arrayUp);
		myMap.put("arrayDownKey", arrayDown);
		
		int max=9;
		String tempo= "";
		for(int i=0; i<myMap.size(); i++){
			Set<String> keys= myMap.keySet();
			for(String onekey: keys){
				int testingX= myMap.get(onekey)[0];
				int testingY=myMap.get(onekey)[1];
				if(map[testingX][testingY]<max){
					max=map[testingX][testingY];
				}
				int[] compare={testingX,testingY};
				if(compare==myMap.get(onekey)){
					tempo=onekey;
				}
				//if (tempo)
				
			}
		}
		
		return 0;
	}
}