package company;

public class Main {

	public static void main(String[] args) {
		
		Firm_ET cmp = new Firm_ET();
		
		RandomStrGen strG = new RandomStrGen();
		cmp.setBulstat(strG.RandomStringGenerator());
		cmp.setDateOfFoundation("21.01.2006");
		cmp.setName("StartUp12345");
	    cmp.setOwner("Yovo");
	    cmp.setCapital(1000000.999);
	    cmp.setCurrentCapital(2500000.999);
	    
	   
	    System.out.println("Company Name "  + cmp.getName());
	    System.out.println("Company Owner "  + cmp.getOwner());
	    System.out.println("Company Bulstat  "  + cmp.getBulstat());
	    System.out.println("Company Date of Foundation "  + cmp.getDateOfFoundation());
	    System.out.println("Company Capital "  + cmp.getCapital());
	    System.out.println("Company CurrentCapital "  + cmp.getCurrentCapital());
	    
	    System.out.println("The profit from the fondation to now is :  " +cmp.Profit() + " !!!");
	}

	
}
