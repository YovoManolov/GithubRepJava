
package ExceptionHandling;
import java.util.*;

public class sample {
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		int x = 1;
		
		do{
				try{
					//we have input variable call input
					System.out.println("Enter first number: ");
			        int num1 = input.nextInt();
			        System.out.println("Enter second number: ");
			        int num2 = input.nextInt();
			        
			        int sum = num1/num2;
			        System.out.println(sum);      
			        input.close();
			        x = 2;
				}  
				catch(ArithmeticException e){
					System.out.println("You cant do this ");
				}
		}while (x == 1);
	}

}
