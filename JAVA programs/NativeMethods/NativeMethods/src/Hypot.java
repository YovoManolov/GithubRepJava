import static java.lang.Math.*;
class Hypot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      double hypot;
      double side1 = 4.4234, side2 = 3.4324;
      
      hypot = sqrt(pow(side1,2) + pow(side2,2));
      
      System.out.print("Hypotenuse of thriangle with side 1  "
                         + side1 + "and side 2  " + side2+ " ");
      System.out.println("is "+ hypot);
	}

}
