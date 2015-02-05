import java.util.Random;


public class buildRandString implements Runnable{

	static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// Create the string for analysis.
	static void buildRandString( int size ){
		String theString = new String();
		Random r = new Random();
		
		for( int i = 0; i < size; i++ ){
			theString += alphabet.charAt(r.nextInt(alphabet.length()));
		}
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}
