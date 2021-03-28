package firstTask;

import java.util.HashMap;

public class FirstTask {

	public static void main(String[] args) {

		/*
		 * ����� ����� [3, 4, 3, 1, 1, 5, 3]. �� �� ��������� ���� ���� ��������, �����
		 * �� �������� ������� ����, ������� � ���������� �� �������: � ���� ������
		 * ������ �� �� �������� ��������.
		 */

		Integer[] arr = { 3, 4, 3, 1, 1, 5, 3 };

		HashMap<Integer, Integer> intRepetative = new HashMap<>();

		for (int i : arr) {

			if (intRepetative.get(i) == null) {
				intRepetative.put(i, 1);
			} else {
				int currentVal = intRepetative.get(i) + 1;
				intRepetative.put(i, currentVal++);
			}
		}

		for (int i : intRepetative.keySet()) {
			if (intRepetative.get(i) == i)
				System.out.println(i);
		}
	}

}
