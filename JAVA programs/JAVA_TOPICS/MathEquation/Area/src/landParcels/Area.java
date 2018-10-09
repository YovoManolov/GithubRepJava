package landParcels;
//земеделските парцели се характеризират с Аrea : size 
//type (nasajdeniq ) (Ако не е fruits or vegetables ne e izpylneno throws AreaException)
//amount (kolichestwo producti);
//amount >= 0 && amount < size*100;
//syzdawam Exception Area Exception {Когато 2те условия горе не са изпълнини се хвурля }
//

public class Area{
   private double size;
   private String type;
   private double amount;
	
   
   public double getSize(){
	   return this.size;
   }
   public void setSize(double size){
	   this.size = size;
   }
	public String getPlantation() {
		return this.type;
	}
	public void setPlantation(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
   
    public boolean checkType() throws AreaException  {
    	   	if(! (this.type.equalsIgnoreCase("Vegetables") || this.type.equalsIgnoreCase("Fruits")) ){
    	   		throw new AreaException("Type is not valid");
    	   	}
    	   	else{
    	   		return true;
    	   	}
    }
    
   //amount >= 0 && amount < size*100;
    public boolean checkAmount() throws AreaException {
    	if(!(this.amount >= 0 && this.amount <= this.size *100))throw new AreaException("Amount is not valid");
    	else return true;
    }
	
}
