package pikVtornik;

import java.util.Scanner;

public class GetBMI1 {
	  static double  getHight(Scanner sc){
    	  double hight ;
    	  System.out.println("Enter yout hight in centimeters ");
    	  hight = sc.nextDouble() * 0.3937;	  
    	  return hight;
      }
	  static double getWeight(Scanner sc){
    	  double weight;
    	  System.out.println("Enter yout weight in kg ");
    	  weight = sc.nextDouble() * 2.2046;
    	  return weight;
      }
	  
	  public double getBMI() {
		  double index = BmiFor.bmiFor();
		  return index;
	  }
}
