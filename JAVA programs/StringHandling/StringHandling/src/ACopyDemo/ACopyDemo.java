package ACopyDemo;

class ACopyDemo {

	static byte a[] = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74 };
	static byte b[] = { 77, 77, 77, 77, 77, 77, 77, 77, 77, 77 };
	public static void main(String[] args) {
		
		System.out.println("a = " + new String(a));
		System.out.println("b = " + new String(b));
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		System.out.println("a = " + new String(a));
		System.out.println("b = " + new String(b));
		
		System.arraycopy(a, 0, a, 2, a.length - 2);
		System.arraycopy(b, 2, b, 0, b.length - 2);
		
		System.out.println("a = " + new String(a));
		System.out.println("b = " + new String(b));
		
		//arraycopy(src, src position ,dest, dest position , length);
	}

}
