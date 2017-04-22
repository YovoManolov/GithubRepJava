/*Demonstrating difference between public and private */
class AccessTest {
	public static void main(String[] args) {
		Test ob = new Test (6,8);
		
		ob.setc(8);
		System.out.println("Returned int is " + ob.getc());
		System.out.println("a : " + ob.a + " b =  " + ob.b );	
	}

}

class Test {
	 int a;
	 public int b;
	 private int c;
	 
	 Test(int j , int k) {
		 a = j;
		 b = k;
	 }
	 // methods to access c
	 void setc(int i) { //set c's value
		 c = i;
	 }
	 
	 int getc () { // get c's value
		 return c*c;
	 }
}