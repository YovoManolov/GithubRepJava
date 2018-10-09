
public class InheritanceEx1 {

	public static void main(String[] args) {
	     A SuperOb = new A ();
	     B SubOb = new B();
	     
	     SuperOb.a = 3;
	     SuperOb.b = 5 ;
	     
	     SuperOb.printA();
	     
	     SubOb.a = 3;
	     SubOb.b = 14;
	     SubOb.k = 20;
	     
	     
	     SubOb.showKsumOfaBk();
	     System.out.println();
	}

}

class A {
	
int a,b;

	void printA(){
		System.out.println("a: " + a + "b =  " + b);
	}
		
}
	
class B extends A {
	int	k;
	
    	void showKsumOfaBk(){
    	System.out.println("Value of k  = " + k);
    	System.out.println("Sum of a + b + k  = " + a + b + k);
    	}
 }
	