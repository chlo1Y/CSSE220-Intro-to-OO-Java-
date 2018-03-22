
/**
 * TODO Put here a description of what this class does.
 *
 * @author TODO <Add your name here>.
 *         Created Dec 15, 2013.
 */
public class Two2DArrayProblems {
	
	/**
	 * 
	 * Count the number of times 4 occurs in the array.  So
	 * the array
	 * 
	 * 		int[][] intArray2 = 
     *       {{0,0,0},
     *       {4,4,0}};
     *
     *       returns 2
	 * @param data 
	 * @return the number of times 4 occurs in the array.
	 */
	public static int count4s(int[][] data) {
		int counter=0;
		for(int i=0; i<data.length; i++){
			for (int j=0; j<data[0].length; j++){
				if (data[i][j]==4){
					counter++;
				}
			}
		}

		return counter;
	}
	
	/**
	 * Takes an array of strings, all of which have equal length.
	 * 
	 * Returns a 2D array of characters, where the characters
	 * correspond to the strings.  
	 * 
	 * {"abc",
	 *  "def"} yields {{'a','b','c'},
     *                 {'d','e','f'}};
	 * @param input 
	 * @return a 2D array of characters, where the characters
	 * correspond to the strings. 
	 *  
	 */
	public static char[][] stringsToCharArrays(String[] input) {
		char[][] result= new char[input.length][input[0].length()];
		for(int i=0; i< input.length; i++){
			for(int j=0; j<input[0].length(); j++){
				result[i][j]=input[i].charAt(j);
			}
		}

		return result;
	}
	
	/**
	 * Takes a square array of integers.
	 * 
	 * Returns true of the array is symmetric.  That is if
	 * the array[i,j] == array[j,i] for all i and j
	 * 
	 * So {{1,0,0},
	 *     {0,1,0},
	 *     {0,0,1}} returns true
     *
     *    {{1,0,3},
	 *     {0,1,0},
	 *     {0,0,1}} returns false because [0,2] != [2,0]
	 * @param input 
	 * @return true of the array is symmetric, false otherwise.
	 */
	public static boolean isSymmetric(int[][] input) {
		for(int i=0; i<input.length; i++){
			for(int j=0; j<input[0].length; j++){
				if (input[i][j]!=input[j][i]){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Takes an array of integers representing a map.
	 * 
	 * On the map there is one square representing the person: '@'
	 * At least one and maybe more squares representing an exit: 'X'
	 * And empty squares: '.'
	 * 
	 * The function returns the shortest distance from the person to 
	 * an exit.  Note the person can't move diagonally so it is the
	 * Manhattan distance.  
	 * 
	 *  For example, in the map
	 * @param input 
	 * @return the shortest Manhattan distance from the person to 
	 * an exit. 
	 *  
	 *  @...
	 *  .X.X
	 *  
	 *  The function returns 2 (east, south)
	 *  
	 *  X.XX
	 *  ....
	 *  .@.. returns 3
	 */
	public static int distanceToExit(char[][] input) {
		int personx = 0;
		int persony = 0;
		int disx = 0;
		int disy=0;
		int distance=input.length;
		int distance2;
		for(int i=0; i<input.length; i++){
			for(int j=0; j<input[0].length; j++){
				if(input[i][j]=='@'){
					personx=i;
					persony=j;
				}
			}
		}
		
		for(int m=0; m<input.length; m++){
			for(int n=0; n<input[0].length; n++){
				if(input[m][n]=='X'){
					disx=m;
					disy=n;
					distance2=Math.abs(personx-disx)+Math.abs(persony-disy);
					if (distance2<distance){
						distance=distance2;
					}
				}
			}
		}
		
		return distance;
	}
}
