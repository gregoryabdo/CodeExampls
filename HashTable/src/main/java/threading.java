
/*****************************************************************
 * 
 * @author gregoryabdo
 *
 ****************************************************************/
public class threading implements Runnable {

	String toAnalize;
	int start, size;
	
	/****************************************************************
	 * 
	 * @param toAnalize
	 * @param start
	 * @param size
	 ****************************************************************/
    public threading(String toAnalize, int start, int size) {
        this.toAnalize = toAnalize;
        this.start = start;
        this.size = size;
    }

    /****************************************************************
     * 
     ****************************************************************/
    public void run() {
    	StringBuilder theString = new StringBuilder();
		
		for( int i = start; i < start + size; i++){
				//if(hs.contains(toAnalize.charAt(i)))
				if(helperFunctions.isValIf(toAnalize.charAt(i)))
						theString.append(toAnalize.charAt(i));
		}
		
    }
}
