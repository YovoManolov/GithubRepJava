package isDigit;

public class IsDigit {

	public static void main(String[] args) {
		char a [] = {'a', 'b', '5', '?', 'A', ' '} ;
		for(int i = 0 ; i< a.length ; i ++) {
			if(Character.isDigit(a[i])) System.out.println(a[i] + " Is a Digit ");
			if(Character.isLetter(a[i])) System.out.println(a[i] + " Is a Letter ");
			if(Character.isWhitespace(a[i])) System.out.println(a[i] + " Is a WhiteSpace ");
			if(Character.isUpperCase(a[i])) System.out.println(a[i] + " Is a UpperCase ");
			if(Character.isSpaceChar(a[i])) System.out.println(a[i] + " Is a SpaceChar ");
		}

	}

}