
public class IsPrimeNumber {

	public static void main(String[] args) {
		int num = 7;
		boolean IsPrime;
		//prime number can be divided only at 1 and itself ;
		// prime number must be greater than 1;
		
		if(num < 2 ){
			IsPrime = false ;
		}
		else IsPrime = true;
		
		for(int i = 2; i <= num/i; i ++ ){
			if((num % i) == 0) {
				IsPrime = false ;
				break;
			}
		}
				

	}

}
