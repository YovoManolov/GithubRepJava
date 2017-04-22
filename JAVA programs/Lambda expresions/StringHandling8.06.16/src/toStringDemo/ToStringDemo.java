package toStringDemo;

class ToStringDemo {

	public static void main(String[] args) {
		Box b =  new Box(12.12,13.13,14.14);
		String s = new String (b.toString());
		
		System.out.println(s);
		System.out.println("Box b : " + s);
	}

}
