package q17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Q17 {

	// How To Sort HashMap In Java By Keys And Values
	public static void main(String[] args) {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

		hashmap.put(22, "A");
		hashmap.put(55, "B");
		hashmap.put(33, "Z");
		hashmap.put(44, "M");
		hashmap.put(99, "I");
		hashmap.put(88, "X");

		System.out.println("Before Sorting:");
		Set<Map.Entry<Integer, String>> set = hashmap.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<Integer, String> pair = 
						(Map.Entry<Integer, String>)iterator.next();
			System.out.print(pair.getKey() + ": ");

		}
	}

}
