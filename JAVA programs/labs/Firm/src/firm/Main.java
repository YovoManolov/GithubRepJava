package firm;

public class Main {

	public static void main(String[] args) {
		Product prod = new Product("product1",18,1234);
		BetterProduct prod1 = new BetterProduct("product2",28,12345);
		
		System.out.println("First prod id : " + prod.getId());
		System.out.println("First prod Name : " + prod.getQuantity());
		System.out.println("First prod Name : " + prod.getName());
		prod.buy(5);
		
		System.out.println("\n\n");
		
		System.out.println("First prod Name : " + prod1.getName());
		System.out.println("First prod Name : " + prod1.getQuantity());
		System.out.println("First prod id : " + prod1.getId());
		prod1.buy(12);
		

	}

}
