package lLaLTest;

import java.util.*;
class TestArrayLinked {

	public static void main(String[] args) {
		List<String> al = new ArrayList <String>();
		List<String> ll = new LinkedList <String>();
		
		al.add("Stamat");
		al.add("Dragan");
		al.add("Petkan");
		al.add("Ivan");
		
		ll.add("Sofia");
		ll.add("Plovdiv");
		ll.add("Blagoevgrad");
		ll.add("Varna");
		
		System.out.println("Printing LinkedList: \n");
		for(String objll: ll){
			System.out.println(objll);
		}
		System.out.println("\n\n\n");
		System.out.println("Printing ArrayList: \n");
		for(String objal : al){
			System.out.println(objal);
		}
		
	  String  a = "yovo" ;
	  al.set(2 , a);
	  
	  System.out.println("\n\n\n");
		System.out.println("Printing ArrayList after seting string a at 4rth position: \n");
		for(String objal : al){
			System.out.println(objal);
		}
	  
		
		 al.remove(2);
		 
		 System.out.println("Printing ArrayList after removing string a at second position: \n");
			for(String objal : al){
				System.out.println(objal);
			}
	}

}

//public object set(int index,Object element);