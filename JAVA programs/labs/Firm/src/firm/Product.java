package firm;

public class Product implements Buyable {
	private String name ;
	private int quantity;
	private int id;
	
	 public Product(String name , int quantity , int id ){
		 this.name = name;
		 this.quantity = quantity;
		 this.id = id;
		 
	 }
	
    public int getId(){
    	return id;
    }
    public int getQuantity(){
    	return quantity;
    }

	@Override
	public int buy(int quantity) {//id ako ima -1ako nqma kolichestwo  ,ako pokupkata e uspeshna namalqwame broq  , ako pokupkata e uspeshna namalqwame broq 
		if(this.quantity >= quantity) {
			this.quantity = this.quantity - quantity ;
			System.out.println("Products ramaining : " + this.quantity);
			return id;
		}else{
			return -1 ;
		}
	}

	@Override
	public String getName() {
		return name;
	}
    
   
}
