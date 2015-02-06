import java.util.HashSet;
import java.util.Random;

/****************************************************************
 * 
 ****************************************************************/
public class helperFunctions {
	
	static HashSet<Character> hs;
	
	/****************************************************************
	 * Create the string for analysis.
	 * @param size
	 * @return
	 ****************************************************************/
	static String generateString( int size ){
		StringBuilder theString = new StringBuilder(); 
		Random r = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for( int i = 0; i < size; i++ )
			theString.append(alphabet.charAt(r.nextInt(alphabet.length())));

		return theString.toString();
	}
	
	/****************************************************************
	 * Remove vals using if statement.
	 * @param toAnalize
	 * @return
	 ****************************************************************/
	static String runTestIf( String toAnalize ){
		StringBuilder theString = new StringBuilder();
		
		for( int i = 0; i < toAnalize.length(); i++)
				if(isCharIf(toAnalize.charAt(i)))
					theString.append(toAnalize.charAt(i));
		
		return theString.toString();
	}
	
	/****************************************************************
	 * Remove vals using HashMap.
	 * @param toAnalize
	 * @return
	 ****************************************************************/
	static String runTestHash( String toAnalize ){
		StringBuilder theString = new StringBuilder();
		
	    // create a hash set
		hs = new HashSet<Character>();
	    
	    // add elements to the hash set
	    /*
	    hs.add('a');
	    hs.add('A');
	    hs.add('e');
	    hs.add('E');
	    hs.add('i');
	    hs.add('I');
	    hs.add('o');
	    hs.add('O');
	    hs.add('u');
	    hs.add('U');
	    */
		
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for( int i = 0; i < alphabet.length(); i++)
			hs.add(alphabet.charAt(i));
		
		for( int i = 0; i < toAnalize.length(); i++)
				if(isValHash(toAnalize.charAt(i)))
						theString.append(toAnalize.charAt(i));

		return theString.toString();
	}
	
	/****************************************************************
	 * Analyze char using if statements.
	 * @param charactor
	 * @return
	 ****************************************************************/
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
	
	/****************************************************************
	 * Analyze char using hash map.
	 * @param charactor
	 * @return
	 ****************************************************************/
	static boolean isValHash( char charactor ){
		return hs.contains(charactor);
	}
	
	/****************************************************************
	 * 
	 * @param charactor
	 * @return
	 ****************************************************************/
	static boolean isCharIf(char charactor){
	String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for( int i = 0; i < alphabet.length(); i++)
			if( charactor == alphabet.charAt(i) )
				return true;
		
		return false;
	}
	
}
