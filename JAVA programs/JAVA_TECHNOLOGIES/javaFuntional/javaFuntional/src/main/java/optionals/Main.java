package optionals;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		/*Optional.ofNullable("Hello")
		.ifPresent(email -> 
			System.out.println("Send email to " + email));*/
		Optional.ofNullable(null).ifPresentOrElse(
				email -> System.out.println("Send email to " + email),
				() -> System.out.println("Cannot send email"));
		
	}
}
