package intParsing;
import java.io.*;

public class IntParsing {
      public static void main(String[] args) throws IOException{
    	  BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    	  
    	  long i = 0;
    	  int sum  = 0;
    	  String str = new String () ;
    	  System.out.println("Enter number 0 to Quit");
    	  
    	  do{
    		  str = br.readLine();
    		  try{
    			  i = Long.parseLong(str);
    			  
    			  
    		  }catch(NumberFormatException e){
    			  System.out.println("Invalid format");
    			  i = 0;			  
    		  }
    		  	sum += i;
    		  	System.out.println("Current sum is : "  + sum);
    	  } while(i!= 0);
      }
}
