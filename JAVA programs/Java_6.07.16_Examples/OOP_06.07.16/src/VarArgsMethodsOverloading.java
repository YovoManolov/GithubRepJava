
public class VarArgsMethodsOverloading {

	public static void main(String[] args) {
		Varargs ob1 = new Varargs();
		
		ob1.VaTest("Yovo", 54.343,321.54,354.652123);
		ob1.VaTest(34.43242, 54,321,354,5435,354,20);
		ob1.VaTest(true, false, false);
	
	}
}

class Varargs{
	
	void VaTest(String x,double...v){
		System.out.print("Number of args: " + v.length);
		System.out.print(";Content:  " );
		for (double i : v) {
			System.out.print(i + " ," );
		}
		System.out.println(" " + x );
		System.out.println();
     }
	
	void VaTest(double b ,int ... v){
		System.out.print("Number of args: " + v.length);
		System.out.print(";Content:  " );
		for (int i : v) {
			System.out.print(i + " ," );
		}
		System.out.println();
		
		System.out.println("Double value printing: " +b);
}
	
	void VaTest(boolean...v){
		System.out.print("Number of args: " + v.length);
		System.out.print(";Content:  " );
		for (boolean i : v) {
			System.out.print(i + " ," );
		}
		System.out.println();
   }
}