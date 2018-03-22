
public class HW1 {
	
	public static void main(String[] args){
		
		/*
		 * test case, this test case is supposed to return true
		 */
		System.out.println(twoEven(2, 3, 6));
		
	}
	
	public static boolean twoEven(int one, int two, int three){
		if (one%2==0 && two%2==0 && three%2!=0){
			return true;
		}else if (one%2==0 && two%2!=0 && three%2==0){
			return true;
		}else if (one%2!=0 && two%2==0 && three%2==0){
			return true;
		}
		return false;
		
		/**
		 * there are three  true cases
		 * 1. the first number is even, the second number is even, but the third one is not
		 * 2. the first number is odd, the second number is even, but the third one is even
		 * 3. the first number is even, the second number is odd, but the third one is even
		 * 
		 * and for the rest cases, just return false will be fine
		 */
	}

	/*
	 * Done: Write a function from scratch down below here.  The function should 
	 * take 3 whole numbers (e.g. no fractions) and return true if exactly 2 of the
	 * three are even.  For example:
	 * 
	 * twoEven(3,2,6) returns true because 2 and 6 are even
	 * twoEven(2,4,6) returns false because all three are even, not just 2
	 * twoEven(3,99,100) returns false because only 100 is even
	 * 
	 * Hint: take a look at section 5.7 in your textbook for some more
	 * examples of boolean functions like AND and NOT.  The rest of chapter
	 * 5 might be good too if you're a bit confused.
	 * 
	 * Be sure to add appropriate Javadoc comments for your function
	 */
	
	/*
	 * Done: Either before or after your write your function, write
	 * a main that tests your function and shows it working.
	 * 
	 */
}
