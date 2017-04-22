package generics;
class GenDemo {	

	public static void main(String[] args) {
	
		Gen<Character> cOb ;			
		cOb =  new Gen<Character>('h');
		cOb.showType();  
		
		char c = cOb.getob();
		System.out.println("Value of c : " + c);
		System.out.println();
		
		Gen<String> sOb;  // creating ob
		
		sOb = new Gen<String> ("Yovo & Magi"); //initializing ob
		
		sOb.showType(); // The name of T is java.lang.String
		
		String str = sOb.getob(); // passing the ob to variable
		 
		System.out.println("Value of str is : " + str);
		 
	}

}
