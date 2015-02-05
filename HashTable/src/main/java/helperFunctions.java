import java.util.HashSet;
import java.util.Random;

public class helperFunctions {
	
	static HashSet hs;
	
	// Create the string for analysis.
	static String generateString( int size ){
		String theString = new String();
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for( int i = 0; i < size; i++ ){
			theString += alphabet.charAt(r.nextInt(alphabet.length()));
		}
		return theString;
	}
	
	// Remove vals using if statement.
	static String runTestIf( String toAnalize ){
		String theString = new String();
		
		for( int i =0; i < toAnalize.length(); i++)
				if(isValIf(toAnalize.charAt(i)))
					theString += toAnalize.charAt(i);
		
		return theString;
	}

	// Remove vals using HashMap.
	static String runTestHash( String toAnalize ){
		String theString = new String();
		
	    // create a hash set
		hs = new HashSet();
	    
	    // add elements to the hash set
	    hs.add("a");
	    hs.add("A");
	    hs.add("e");
	    hs.add("E");
	    hs.add("i");
	    hs.add("I");
	    hs.add("o");
	    hs.add("O");
	    hs.add("u");
	    hs.add("U");
		
		for( int i = 0; i < toAnalize.length(); i++)
				if(isValHash(toAnalize.charAt(i)))
						theString += toAnalize.charAt(i);
		
		return theString;
	}
	
	// Analyze char using if statements.
	static boolean isValIf( char charactor ){
		
		if(charactor == 'a' || charactor == 'A')
			return true;
		
		if(charactor == 'e' || charactor == 'E')
			return true;
		
		if(charactor == 'i' || charactor == 'I')
			return true;
		
		if(charactor == 'o' || charactor == 'O')
			return true;
		
		if(charactor == 'u' || charactor == 'U')
			return true;
		return false;
	}
	
	// Analyze char using hash map.
	static boolean isValHash( char charactor ){
		return hs.contains(charactor);
	}
}
