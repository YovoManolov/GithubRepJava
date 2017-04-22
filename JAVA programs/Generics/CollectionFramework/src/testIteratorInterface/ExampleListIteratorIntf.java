package testIteratorInterface;
import java.util.*;

public class ExampleListIteratorIntf {

	public static void main(String[] args) {
		ArrayList <String> al = new ArrayList<String> () ;
		al.add(0,"first");
		al.add(1,"Second");
		al.add(2,"Third");
		al.add(3,"Fourth");
		
		System.out.println("Element at second position .. : "  + al.get(2) +" \n");
		
		//We must use ????? ListIerator not Iterator !!!!!! ?????
		ListIterator <String> it = al.listIterator();
		
		
		System.out.println("Traversing elements in forward direction...");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("\n");
		
		System.out.println("Traversing elements in backword direction...");
		while( it.hasPrevious()){
			System.out.println(it.previous());
		}
		
	 

	}

}
