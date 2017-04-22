package interfaceExample;

public class Product implements Buyable{
	 private int id;
	 private String name;
	 protected int quantity;
	 
	 public Product(int id,String name,int quantity){
		 this.setId(id);
		 this.setQuantity(quantity);
		 this.name = name;
	 }
	 
	 public void setId(int id){
		 if(id <= 0){
			 System.out.println("Id was not set with right value");
			 System.out.println("The value must be bigger than zero!!!");	 
		 }
		 this.id = id;
	 }
	 public int getId(){
		 return this.id;
	 }
	 public String getName() {
		return name;
	 }
	 public int getQuantity() {
		 if(quantity <= 0){
			 System.out.println("quantity was not set with right value");
			 System.out.println("The value must be bigger than zero!!!");	 
		 }
		return quantity;
	 }
	 public void setQuantity(int quantity) {
	 	this.quantity = quantity;
	 }
 
	 
	 
	 
	 public int buy (int quantity){
		 if(this.quantity >= quantity){
			 System.out.println("We have enought quantity so the Buy operation can succeed");
			 this. quantity = this.quantity - quantity;
			 System.out.println("Remaining elements "  + this.quantity);
			 return 1;
		 }
		 else {
			 System.out.println("The operation can't be executed");
	         return -1;
	     }
	 }
}
