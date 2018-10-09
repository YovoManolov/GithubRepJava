package systemProperties;
import java.io.*;
import java.util.*;

public class SystemProperties {
   public static void main (String args[]) throws Exception{

	   //  Properties <- HashTable <- Map 
	   // connection between Properties class and Map interface 
	  
       Properties p = System.getProperties();
	   Set set = p.entrySet();     //  Properties <- HashTable <- Map.entrySet()  :)
	   
	   // entrySet method declared by ??? Map Interface ??? returns a  Set containing the  map entries.
	   // Each of this set elements is a map
	   
	   Iterator it = set.iterator();
	   while(it.hasNext()){
		   Map.Entry entry = (Map.Entry)it.next();
           System.out.println(entry.getKey() + "   " + entry.getValue());
		   }
   }
}
