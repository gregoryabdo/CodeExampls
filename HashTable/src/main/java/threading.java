import java.util.HashSet;


public class threading implements Runnable {

	String toAnalize;
	int start, size;
	HashSet hs;
	
    public threading(String toAnalize, int start, int size) {
        this.toAnalize = toAnalize;
        this.start = start;
        this.size = size;
        
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
    }

    public void run() {
		String theString = new String();
		
		for( int i = start; i < start + size; i++){
			//System.out.println("Char " + i + " " + toAnalize.charAt(i));
				if(hs.contains(toAnalize.charAt(i)))
						theString += toAnalize.charAt(i);
		}
		
    }
}
