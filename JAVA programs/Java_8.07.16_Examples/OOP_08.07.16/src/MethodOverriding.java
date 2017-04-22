
public class MethodOverriding {

	public static void main(String[] args) {
		B b = new B (2,4,3,542);
		b.view();
	}

}

class A{
	int k,j;
	
	A(int a,int b){
		k = a;
	    j = b;
	}
	
   void view (){
	   System.out.println("k: " + k + " j: " + j);
   }
   
}

class B extends A {
	int w,z;
	
		B(int a,int b,int c, int d){
			super(a, b);
		    w = c;
		    z = d;
		}
		 void view(){
			   super.view();
			   System.out.println("w: " + w + " z: " + z);
		   }
}