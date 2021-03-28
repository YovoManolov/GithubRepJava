package thirdTask;

public class ThirdTask {

	public static void main(String[] args) {
		/*
		 * задача, в която за числата от 1 до 100
		 *  трябва да се изпише foobar, ако се дели на 3 и на 5 
		 *  да се изпише foo, ако числото се дели на 3, 
		 *  да се изпише bar,ако се дели на 5 и
		 *  иначе да се изпише самото число (ако не се дели нито на 3, нито на 5).
		 */

		for (int i = 1; i < 100; i++) {
			System.out.println(i +" : " + fooBar(i));
		}
	}

	private static String fooBar(int i) {
		
		if (i % 3 == 0 && i % 5 == 0) {
			return "foobar";
		} else if (i % 3 == 0) {
			return "foo";
		} else if (i % 5 == 0) {
			return "bar";
		} else {
			return new String("" + i);
		}

	}

}
