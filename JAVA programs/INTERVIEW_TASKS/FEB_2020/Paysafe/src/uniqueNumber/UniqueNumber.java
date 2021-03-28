package uniqueNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueNumber {
	public static void main(String[] args) {
		int[] intArr = {3,2,3,4,2,1,1,4,9};
		
		HashMap<Integer,Integer> intHashMap = new HashMap<Integer,Integer>();
	
		for(int i : intArr) {
			intHashMap.put(i, intHashMap.get(i) == null ? 1: (intHashMap.get(i)+1) );
		}
		
		Map<Integer, Integer> result = intHashMap.entrySet()
			.stream()
			.filter(x -> x.getValue().intValue() == 1)
			.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		
		System.out.println(result);
	}
}	
