package indexOfDemo;

class IndexOfDemo {

	public static void main(String[] args) {
			String s = "Now is the time for all good men " +
			"to come to the aid of their country.";
			System.out.println(s);
			
			System.out.println("The legth of array s is : " + s.length());
			System.out.println();
			
			
			System.out.println("indexOf(t) = " +
			s.indexOf('t')); // FIRST index of "t" 
			System.out.println("lastIndexOf(t) = " +
			s.lastIndexOf('t')); 
			System.out.println("indexOf(the) = " +
			s.indexOf("the")); 
			System.out.println("lastIndexOf(the) = " +
			s.lastIndexOf("the")); //same as the first index of 't'
			System.out.println("indexOf(t, 10) = " +
			s.indexOf('t', 10)); ///int indexOf(int ch, int startIndex) 
			System.out.println("lastIndexOf(t, 60) = " +
			
			//For lastIndexOf( ), the search runs
			//from startIndex to zero.		 BACWORDS		
			s.lastIndexOf('t', 60));//int lastIndexOf(String str, int startIndex)
			System.out.println("indexOf(the, 10) = " +
			s.indexOf("the", 10));///int indexOf(int ch, int startIndex) 
			
			//For lastIndexOf( ), the search runs
			//from startIndex to zero.		 BACWORDS	
			System.out.println("lastIndexOf(eir, 60) = " +
			s.lastIndexOf("eir", 69));
	}

}