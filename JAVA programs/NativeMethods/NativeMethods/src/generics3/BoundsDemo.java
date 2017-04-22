package generics3;

class BoundsDemo {
	public static void main(String[] args) {
		Integer inums[] = {432,432,4,32,43,2,43};
		
		AverageNumbGen <Integer> Iob;
		Iob = new AverageNumbGen<Integer>(inums);
        
		double result = Iob.average();
        System.out.println("The average of Ints : " + result);
        
        ///_________________________________________________
        ///_________________________________________________
        
        Double dnums[] = {543.342,42.324,4.32,332222.434,
        		         43243242.2433,432.2,545.54543};
	
		AverageNumbGen<Double> Dob;
		Dob = new AverageNumbGen <Double>(dnums);
        
		double result1 = Dob.average();
        System.out.println("The average of Doubles : " + result1);
        
              
	}
}
