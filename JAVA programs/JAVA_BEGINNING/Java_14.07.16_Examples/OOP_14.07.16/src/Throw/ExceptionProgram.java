package Throw;

public class ExceptionProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try{
    	   throw new NullPointerException("Problem");
       }catch ( NullPointerException npe){
    	   throw new RuntimeException(npe);
       }
		
	}

}
