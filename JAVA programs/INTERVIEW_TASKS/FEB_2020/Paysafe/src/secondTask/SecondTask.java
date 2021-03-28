package secondTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SecondTask {
	
	public static void main(String[] args) {
		
		
		/*
		 * Даден е
		 * 		 списък от списъци 
		 * 		[[1, 2 , 3], [a, b, c], [6, d]].
		 * 
		 *  Да се долепят елементите на всеки списък с останалите, 
		 *  да се върне един списък, който  изглежда така 
		 *  [1a6, 1ad, 1b6, 1bd, 1c6, 1cd , 2a6 ... etc.]. 
		 *  Броя на  подаваните списъци не е константен.
		 */
		
		Object [][] arr = {
				{1,2,3},
				{'a','b','c'},
				{6,'d'}
		};
		
		ArrayList<ArrayList<Object>> listOflists = new ArrayList<ArrayList<Object>>();
		
		List<Character> arrList1 = Arrays.asList('1','2','3');
		List<Character> arrList2 = Arrays.asList('a','b','c');
		List<Character> arrList3 = Arrays.asList('6','b');

		List<List<Character>> listOfCharacterLists = Arrays.asList(arrList1,arrList2,arrList3);
		Iterator<List<Character>> itListChar = recursiveCombinator(listOfCharacterLists,0).iterator();
		
		while(itListChar.hasNext()) {
			List<Character> listChar = itListChar.next();
			System.out.println(listChar.toString());
		}
		
	}
	
	private static List<List<Character>> recursiveCombinator(List<List<Character>> input, int i) {
		
		// stop condition
		if(i == input.size()) {
			// return a list with an empty list
			List<List<Character>> result = new ArrayList<List<Character>>();
			result.add(new ArrayList<Character>());
			return result;
		}
		
		List<List<Character>> result = new ArrayList<List<Character>>();
		List<List<Character>> recursive = recursiveCombinator(input, i+1); // recursive call
		
		// for each element of the first list of input
		for(int j = 0; j < input.get(i).size(); j++) {
			// add the element to all combinations obtained for the rest of the lists
			for(int k = 0; k < recursive.size(); k++) {
	                        // copy a combination from recursive
				List<Character> newList = new ArrayList<Character>();
				for(Character c : recursive.get(k)) {
					newList.add(c);
				}
				// add element of the first list
				newList.add(input.get(i).get(j));
	                        // add new combination to result
				result.add(newList);
			}
		}
		return result;
	}
	
	
}
