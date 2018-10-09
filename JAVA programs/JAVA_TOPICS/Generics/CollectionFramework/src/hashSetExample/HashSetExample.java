package hashSetExample;
import java.util.*;

class HashSetExample {

	public static void main(String[] args) {
		HashSet <String> hs = new HashSet <String>();
		int i = 0;
	    while (i<6){
	    	hs.add(" " + i);
	    	i++;
	    }
	    
	    System.out.println("Printing HashSet");
	    for(String ob : hs){
	       System.out.println(ob);    
	    }
	    
	    
	    System.out.println("Must throw error mesage because HashSet \n"
	    	            	+ " can't hold 2 equal values \n\n");
	    
	    try{
	    	hs.add(" " + 6);hs.add(" " + 2);
	    	 System.out.println("Printing HashSet");
	  	    for(String ob : hs){
	  	       System.out.println(ob);    
	  	    }
	    }catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	    
	    System.out.println("\n\n It didn't throw exception " );
	    System.out.println	("it just  do not add duplicate numbers ");
	}

}
