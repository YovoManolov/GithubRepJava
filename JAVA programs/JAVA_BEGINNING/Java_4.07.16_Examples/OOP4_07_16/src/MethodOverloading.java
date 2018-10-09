
public class MethodOverloading {

	public static void main(String[] args) {
		OverloadDemo overloadDemo = new OverloadDemo() ;
	    overloadDemo.test(6,8);
	    overloadDemo.test(6,8);
	    overloadDemo.test(8.00000);
		
	}

}

class OverloadDemo {
	void test (){
	System.out.println(" No parameters ! ");
	}
	
	void test (int a){
		System.out.println("a: " +a );
	}
	void test (int a , int b) {
		System.out.println("a: " + a + "b: " +b ) ;
	}
	void test (double a) {
		System.out.println("result: " + a * a) ;
	}
}
	