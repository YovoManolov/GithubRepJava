package company;

import java.util.Random;

class RandomStrGen {
	 public String RandomStringGenerator(){
		  Random rd = new Random();
		  
		  char[] elements = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		  StringBuilder generatedString = new StringBuilder() ;
		  
		  for(int i = 0 ;i <10 ;i++){
			  char c = elements[rd.nextInt(elements.length)];
			  generatedString.append(c);
		  }
		  return generatedString.toString();
	   }
}
