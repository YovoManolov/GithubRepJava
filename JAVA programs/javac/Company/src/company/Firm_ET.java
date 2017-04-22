package company;

public class Firm_ET extends Company{
	private String Owner;
	private double Capital;
	private double CurrentCapital;
	 public Firm_ET(){
		 super();
	 }
	 
	 public void setOwner(String Owner){
		 this.Owner = Owner;
	 }
	 
	 public String getOwner(){
		 return this.Owner;
	 }
	 
	 
	 
	 public void setCapital(double Capital){
		 this.Capital = Capital;
	 }
	 public double getCapital(){
		 return this.Capital;
	 }
	 

	 public void setCurrentCapital(double CurrentCapital){
		 this.CurrentCapital = CurrentCapital;
	 }
	 public double getCurrentCapital(){
		 return CurrentCapital;
	 }
	 
	 
	 public double Profit(){
		 double profit = (getCurrentCapital() - getCapital());
		 return profit;
		}
}
