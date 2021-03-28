package functionalInterface;

import java.util.function.Consumer;

public class _Consumer {
	public static void main(String[] args) {
		//Normal java funtion
		greetCustomer(new Customer("Maria","99999"));
		
		//Consumer funcitonal interface
		greetCustomerConsumer.accept(new Customer("Maria","99999"));
	}
	
	static Consumer<Customer> greetCustomerConsumer = 
			customer -> System.out.println("Hello " 
						+ customer.customerName 
				+", thanks for registering phone number: " 
					+ customer.customerPhoneNumber);
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName 
				+", thanks for registering phone number: " + customer.customerPhoneNumber);
	}
	
	static class Customer { 
		
		private final String customerName; 
		private final String customerPhoneNumber;
		
	    Customer(String customerName, String customerPhoneNumber) {
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}
		
		
	}
}
