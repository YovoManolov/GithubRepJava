
public class OpBitEquals {

	public static void main(String[] args) {
		 int a = 1 , b = 2 , c = 3 ;
		 
		a |= 4;
		b >>= 1;
		c <<= 1;
		a ^= c; 
		
		//  a = 0101 = 5 
		//  b = 0011 = 3
		//  c = 0110 = 6
		//  a = 0011 = 3

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
	}
}


