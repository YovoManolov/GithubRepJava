package example6;

interface StringFunc { 
	
	  String func(String n);
	  
}

class LamdaAsArgumentDemo {
	
	public static void main(String args[])
	{
			String inStr = "Lambda add power to Java";
			String outStr;
			System.out.println(" Here is the input string: " + inStr);

			
			outStr = stringOp((str) -> str.toUpperCase(), inStr);
			System.out.println("The string in uppercase: " + outStr);
			
			outStr = stringOp((str) -> {
											String result = " ";
											for(int i = 0; i < str.length(); i++)
											if(str.charAt(i) != ' ')
											result += str.charAt(i);
											return result;
										}, inStr);
			
			
			System.out.println("The string with spaces removed: " + outStr);
			
			StringFunc reverse = (str) -> {
				String result = " ";
				int i;
				for(i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
				return result;
			};
			
		
			System.out.println("The string reversed: " +
			stringOp(reverse, inStr));
			}
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}
  }