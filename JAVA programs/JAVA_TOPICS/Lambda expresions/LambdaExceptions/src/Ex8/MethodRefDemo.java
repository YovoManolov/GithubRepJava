package Ex8;

interface StringFunc {
	String func(String n);
}
// Now, this class defines an instance method called strReverse().
class MyStringOps {
	//t strReverse( ) is now an instance method of MyStringOps.
	String strReverse(String str) {
		String result = "";
		int i;
		for(i = str.length()-1; i >= 0; i--)
		result += str.charAt(i);
	return result;
	}
}
class MethodRefDemo {
	// This method has a functional interface as the type of
	// its first parameter. Thus, it can be passed any instance
	// of that interface, including method references. 
	
	// Първи параметър функцията , втори параметър данните , които обработва
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}
	public static void main(String args[])
	{
		String inStr = "Lambdas add power to Java";
		String outStr;
		//Inside main( ), an instance of MyStringOps called strOps is created.
		
		//This instance is used to create the || method reference || to strReverse 
		//in the call to stringOp, as shown again, here:
	    //outStr = stringOp(strOps::strReverse, inStr);
		MyStringOps strOps = new MyStringOps( );
		// Now, a method reference to the instance method strReverse
		// is passed to stringOp().
		outStr = stringOp(strOps::strReverse, inStr);
		System.out.println("Original string: " + inStr);
		System.out.println("String reversed: " + outStr);
	}
}
