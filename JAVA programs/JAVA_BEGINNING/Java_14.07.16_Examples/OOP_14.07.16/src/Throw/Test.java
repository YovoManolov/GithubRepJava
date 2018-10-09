package Throw;

import java.io.IOException;

public class Test {
    
	public void run() throws ServerException{
		
		//some kind of returnd value from some kind  complexx process
		// 0 =  success
		// anything else =  error code
		int code  = 1;
		
		if (code != 0){
			//Same thing's go wrong  
			//throw new IOException("Could not connect to server ");
			throw new ServerException("Could not connect to server ");
		}
		
		System.out.println("Running successfully. ");
	}
}
