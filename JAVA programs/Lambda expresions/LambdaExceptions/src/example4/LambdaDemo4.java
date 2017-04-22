package example4;

class LambdaDemo4 {

	public static void main(String[] args) {
		
		StringTest1 reverseString = (str) ->{
			String result = "";
	        int i;
	        for(i = str.length()-1 ; i >= 0 ; i--){
	        	//This method returns the character located at the String's 
	        	//specified index. The string indexes start from zero.
	        	result += str.charAt(i);
	        }	
	        	return result ;
	    }; //semicolon is needet for the end of lambda block expression
	
		System.out.println("Reversed of Test is " + reverseString.func("Test"));
		System.out.println("Reversed of Example is " + reverseString.func("Example"));

	}

}
