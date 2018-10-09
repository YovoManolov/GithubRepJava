package getCharDemo;

class getCharDemo {

	public static void main(String[] args) {
		String s = "This is a demo"; // WHITE SPACES HAVE ALSO INDEXES
		int start = 10;
		int end = 14;
		char buf[] = new char[4];
		s.getChars(start, end, buf, 0);
		System.out.println(buf);
		}

}
