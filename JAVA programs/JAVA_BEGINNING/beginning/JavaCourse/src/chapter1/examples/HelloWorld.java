package chapter1.examples;


public class HelloWorld {
       public static void main (String[] args){
    	   
    	   int firstNumber;
    	   int secondNumber, answer ;
    	   
    	   firstNumber=3;
    	   secondNumber=20; 
    	   
    	   answer = secondNumber % firstNumber;
    	   
    	   //System.out.println("Total modulus " +  answer);
    	   
    	   
    	   float meal ;
    	   meal = 65.43F;
    	   
    	   float tip = 0.15F * meal ;
    	   float total = meal + tip;
    	   
    	   System.out.println("The meal coast $ " + meal);
    	   System.out.println("The tip is $ " + tip);
    	   System.out.println("The total bill  is $ " + total);

    	   
       }
}
