/**
 * This class runs the SumArrayInParallel application.
 * 
 * @author wilkin. Updated by defoe on Nov 9, 2015 
 *
 */
public class Main {
	public static void main(String[] args) {
		int n = 200000000;
		//int numThreads = 4;
		long startTime = System.currentTimeMillis();
		Data data = new Data();
		//TODO 3 set data will need numThreads as a second argument Step 3
		data.setData(n);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Done creating array, took " + 
		                    (endTime-startTime)  + " ms");
		System.out.flush();
		
		
		startTime = System.currentTimeMillis();
		long c = sumSerial(data);
		endTime = System.currentTimeMillis();
		
		System.out.println("Done summing array serially, took "+ 
                (endTime-startTime) + " ms");
		System.out.flush();
		
		
		//TODO 4F call sumParallel here, step 4(F)
	}
	
	public static long sumSerial(Data data) {
		long result = 0;
		for(int i = 0; i < data.a.length; i++)
			result += data.a[i];
		return result;
	}
	
	//TODO 4E method sumParallel(...) goes here, steps 4(E) and 6
	//TODO 6
}
