
/****************************************************************
 * 
 * @author gregoryabdo
 *
 ****************************************************************/
public class ValRemoveTest {
	
	/****************************************************************
	 * 
	 * @param args
	 ****************************************************************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int stringSize = 40000000;
		String testString = helperFunctions.generateString(stringSize);
		System.out.println("String Created. Length: " + testString.length());

		String output;
		
		// Run the If test.
		long startTime = System.nanoTime();
		output = helperFunctions.runTestIf(testString);
		long endTime = System.nanoTime();
		
		System.out.print(endTime - startTime);
		System.out.println("ns for if statement test. Returned length is: " + output.length());

		
	    // Run the hash test.
	    startTime = System.nanoTime();
	    output = helperFunctions.runTestHash(testString);
		endTime = System.nanoTime();
		
		System.out.print(endTime - startTime);
		System.out.println("ns for hashset test. Returned length is: " + output.length());
		
		
		// Run the threading test.
	    startTime = System.nanoTime();
		
	    threading threadOne = new threading(testString, 
	    		testString.length()/4 * 0 , testString.length()/4);
	    Thread t1 = new Thread(threadOne);
	    t1.start();
	    
	    threading threadTwo = new threading(testString, 
	    		testString.length()/4 * 1, testString.length()/4);
	    Thread t2 = new Thread(threadTwo);   
	    t2.start();

	    threading threadThree = new threading(testString, 
	    		testString.length()/4 * 2, testString.length()/4);
	    Thread t3 = new Thread(threadThree);   
	    t3.start();
	    
	    threading threadFour = new threading(testString, 
	    		testString.length()/4 * 3, testString.length()/4);
	    Thread t4 = new Thread(threadFour);   
	    t4.start();

	    try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    try {
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTime = System.nanoTime();
		
		System.out.print(endTime - startTime);
		System.out.println("ns Threaded");
	}

}
