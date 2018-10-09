package pikVtornik;
import java.util.Scanner;
public class BmiFor {
	
   static double bmiFor(){
	   double index;
	   Scanner sc1 = new Scanner(System.in);
	   //weight*703/ (height*height).
	   double Hight = GetBMI1.getHight(sc1);
	   index = (double)(  (GetBMI1.getWeight(sc1) * 703)  / (Hight * Hight));  
	   return index;
   }
}
