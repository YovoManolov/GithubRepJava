package firm;

public class BetterProduct extends Product {

	public BetterProduct(String name, int quantity, int id) {
		super(name, quantity, id);
	}
	
	public int buy(int quantity) {//id ako ima -1ako nqma kolichestwo  ,ako pokupkata e uspeshna namalqwame broq  , ako pokupkata e uspeshna namalqwame broq 
		if(super.getQuantity() >= quantity) {
			System.out.println("Products ramaining : " + (super.getQuantity() - quantity));
			return super.getId();
		}else{
			System.out.println( "There ne enought product aviable ");
			return -1;
		}
	}
       
}