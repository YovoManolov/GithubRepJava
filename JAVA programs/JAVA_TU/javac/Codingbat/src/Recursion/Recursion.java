package Recursion;

public class Recursion {
	public static void main(String [] args){
		 int number = 5;
		  Recursion r = new Recursion();
	      System.out.println(" " + r.blocks(number)); 
	     }
	public int blocks(int n){
		 System.out.println("Tianlge (" + n +" )" + " : " + n); 
		 return blocks(n - (n-1)) ;
	
	}
}
