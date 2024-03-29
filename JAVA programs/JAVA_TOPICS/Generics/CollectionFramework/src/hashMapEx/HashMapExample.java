package hashMapEx;

import java.util.HashMap;
import java.util.Map;
class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashMap <Integer,String > hmis = new HashMap <Integer,String>();
        
        hmis.put(101 , "yovo");
        hmis.put(102 , "magi");
        hmis.put(103, "family");
        
         //put , putAll , remove, get ,containsKay , keySet , entrySet
        System.out.println("Set map that contains all keys and values  : \n");
        System.out.println(hmis.entrySet()); 
        System.out.println("Set map that contains all the keys : \n");
        System.out.println(hmis.keySet());
        
        /*EntrySet takes  all el. ( key  + value )  in contrast 
         * to keySet , that takes just all keys*/
        
        System.out.println("hash map before puting new element :  \n");
        for(Map.Entry <Integer,String> me :hmis.entrySet()){
        	System.out.println("The key is:  " + me.getKey() + "; The value is:  " + me.getValue());
        }
      
        
        hmis.put(100, "string0");
        System.out.println("hash map after puting new element : \n");
        for(Map.Entry  <Integer,String> me :hmis.entrySet()){
        	System.out.println("The key is:  " + me.getKey() + "; The value is:  " + me.getValue());
        }
        
        String snew = hmis.get("string0");
        System.out.println(snew);
        
        
        System.out.println("HashMap after using get() : \n");
        for(Map.Entry <Integer,String> me1 :hmis.entrySet()){
        	System.out.println(me1);
        }
	}

}
