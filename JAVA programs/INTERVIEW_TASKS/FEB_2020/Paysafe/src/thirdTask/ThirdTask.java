package thirdTask;

public class ThirdTask {

	public static void main(String[] args) {
		/*
		 * ������, � ����� �� ������� �� 1 �� 100
		 *  ������ �� �� ������ foobar, ��� �� ���� �� 3 � �� 5 
		 *  �� �� ������ foo, ��� ������� �� ���� �� 3, 
		 *  �� �� ������ bar,��� �� ���� �� 5 �
		 *  ����� �� �� ������ ������ ����� (��� �� �� ���� ���� �� 3, ���� �� 5).
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
