import java.util.HashSet;
import java.util.Random;

/****************************************************************
 * 
 * @author gregoryabdo
 * 
 ****************************************************************/
public class helperFunctions {
	
	static HashSet<Character> hs;
	//static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String alphabet = "aeiouAEIOU";
	
	/****************************************************************
	 * Create the string for analysis.
	 * @param size
	 * @return
	 ****************************************************************/
	static String generateString( int size ){
		StringBuilder theString = new StringBuilder(); 
		Random r = new Random();
		
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
				if(isValIf(toAnalize.charAt(i)))
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
		
		for( int i = 0; i < alphabet.length(); i++)
			if( charactor == alphabet.charAt(i) )
				return true;
		
		return false;
	}
	
}
