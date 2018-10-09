package interfaceExample;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Buyable []b = new Buyable [2];
		try {
			b[0] = new Product(1234,"product1",30);
			b[1] = new BetterProduct(12345,32,"product2");
			
			for(int i = 0 ;i<2; i++){
				System.out.println("The names of the products are : " + b[i].getName() + " \n");
			}

			int flag = 0 ;
		while(true){
			System.out.println("How much elements do you want to buy from Product ?");	
			int count = sc.nextInt();
			flag = b[0].buy(count);
			System.out.println(flag);
			if(flag < 0) break;
			
			
			System.out.println("How much elements do you want to buy from BetterProduct ? ");	
			count = sc.nextInt();
			flag = b[1].buy(count);
			System.out.println(flag);
			if(flag < 0) break;
		}

		 	
		}catch(ArrayIndexOutOfBoundsException e){
			e.getMessage();
		}catch(ArithmeticException e){	
			e.getMessage();
		}catch(RuntimeException e){
			e.getMessage();
		}

	}

}
