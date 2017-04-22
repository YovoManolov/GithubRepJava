package company;

public class Company {
	
	private String Name;
	private String DateOfFoundation ;
	private String Bulstat ;
	   


	public String getName() {
		return Name;
	}
	
	
	
	public void setName(String name) {
		Name = name;
	}
	
	
	
	public String getDateOfFoundation() {
		return DateOfFoundation;
	}
	
	
	
	public void setDateOfFoundation(String dateOfFoundation) {
		DateOfFoundation = dateOfFoundation;
	}
	
	
	
	public String getBulstat() {
		return Bulstat;
	}
	
	public void setBulstat(String bulstat) {
		if(bulstat.length() == 10){
			Bulstat = bulstat;
		}else System.out.println("The lenght of bulstat is incorrect"
				               + " , please enter correct bulstat");
		
	}
}
