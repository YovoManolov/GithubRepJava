package wildCard;

public class WildCardDemo {

	public static void main(String[] args) {
		Integer inums[] = {1,2,3,4,5,6};
		Stats<Integer> iOb = new Stats<Integer>(inums);
		double a = iOb.average();
		System.out.println("Average of ints : " + a);
		
		Double dnums[] = {1.0,2.0,3.0,4.0,5.0,6.0};
		Stats<Double> dOb = new Stats<Double>(dnums);
		double b = dOb.average();
		System.out.println("Average of double values  is : " + b);
		
		Float fnums[] = {0.5F,2.0F,3.0F,4.7F,5.0F,6.0F};
		Stats<Float>fOb = new Stats<Float>(fnums);
		double c = fOb.average();
        System.out.println("Average of floats is " + c);
        
        
        System.out.print("Are average values of iOb and dOb the same: ");
        if((iOb.sameAverage(dOb)) == true)System.out.println("true");
        else System.out.println("false");
        
        System.out.print("Are average values of iOb and fOb the same: ");
        if((iOb.sameAverage(fOb)) == true)System.out.println("true");
        else System.out.println("false");
	}
}
