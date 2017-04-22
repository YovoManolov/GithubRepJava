package arrayListTest;

import java.util.*;
class TestArrayList {

	public static void main(String[] args) {
		//creating arraylist
		ArrayList <String> al = new ArrayList<String>();
        al.add("Buba");
        al.add("Mates");
        al.add("Friend");
        
        Iterator itr = al.iterator();
        while (itr.hasNext()){
        	
        	System.out.println(itr.next());
        }
        //getting iterator from ArrayList to traverse elements
        
	}

}
