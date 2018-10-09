package tutorialMethodRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MethodReferenceDemoO4 {

	public static void main(String[] args) {
		 List <Integer> numberList = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
         
    }
	public static boolean isEvenNumber(Integer x ){
		return (x & 1) == 0;
		}
    public static List<Integer> testPresidence(List<Integer> list, Predicate<Integer> predicate) {
    	List <Integer> returnList =  new ArrayList<> ();
    	for(Integer x : list) {
    		if(predicate.test(x))returnList.add(x);
    	}
    	return returnList;
    }
}
