package interfaceExample;

public class BetterProduct extends Product{
	
	public BetterProduct(int id,int quantity , String name){
		super(id,name,quantity);
		}	

    @Override
	 public int buy(int quantity) throws RuntimeException {
          int productId = super.buy(quantity);
          if(productId == -1){
        	  throw new RuntimeException("There are no more such items");
          }
          
          return productId; 
          
     }
}
