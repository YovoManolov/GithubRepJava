package hashTable;
import java.util.Enumeration;
import java.util.Hashtable;;
class HashTable {

	public static void main(String[] args) {
		Hashtable <String , Double> ht = new Hashtable <String ,Double >(5);
		
		Enumeration <String> names;
		double bal = 0.00;
		String str;
		
		ht.put("key0" , new Double(334.234));
		ht.put("key1" , new Double(543.342));
		ht.put("key2" , new Double(743.342));
		ht.put("key3" , new Double(573.326));
		ht.put("key4" , new Double(973.324));
		ht.put("key5" , new Double(1573.32));
		
		names = ht.keys();
		
		while (names.hasMoreElements()){
			str = names.nextElement();
			System.out.println(str + " : " + (Double)ht.get(str));
		                       
		}
		
		System.out.println("Changing the value of key 5");
		bal = ht.get("key5").doubleValue();
		ht.put("key5" , new Double(bal + 350.00));	
        
		names = ht.keys();
		System.out.println("Afer changing the value of key 5");
		while(names.hasMoreElements()){
			str = names.nextElement();
			System.out.println(str + " : " + (Double)ht.get(str));	
		}
		
		if(ht.isEmpty()){
			System.out.println("The HashMap is Empty");
		}
		else {
			System.out.println("The HashMap is not empty");
		}
		
	}

}
