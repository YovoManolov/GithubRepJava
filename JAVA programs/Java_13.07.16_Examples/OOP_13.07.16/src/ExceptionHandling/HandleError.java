package ExceptionHandling;

import java.util.Random;

class HandleError {

	public static void main(String[] args) {
		Random r = new Random();
		int a, b, c;
		 
		for(int i = 0 ; i < 50000 ;i++){
			try{
				 a  = 12345;
				 b = r.nextInt();
				 c = r.nextInt();
		        
		       a = a / (b/c);

			}
			 catch(ArithmeticException e){
				 System.out.println("Division by zero is not allowed");
				 a = 0;
			 }
			System.out.println("a: " + a);
		}

	}

}
