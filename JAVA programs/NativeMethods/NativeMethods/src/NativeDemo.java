
public class NativeDemo {
int i;
	public static void main(String[] args) {
		NativeDemo ob = new NativeDemo();
		ob.i = 10;
		
		System.out.println("this is the ob.i before the native method" + ob.i);
		
		ob.test();
		System.out.println("This is ob.i after the native method"  + ob.i);
	}
	
	public native void test ();
	
	
	//loading DLL that cointains static method
	static {
		System.loadLibrary("NativeDemo");
	}

}
