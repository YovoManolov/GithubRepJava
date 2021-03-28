package finalsection;

import java.util.function.BiFunction;

public class Lambdas {

	public static void main(String[] args) {
		// Function<String, String> upperCaseName =
		// String::toUpperCase; //method reference
		
		BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
			if (name.isBlank())
				throw new IllegalArgumentException("");
			else {
				System.out.println(age);
				return name.toUpperCase();
			}
		};
		
		String nameToUpperCase = upperCaseName.apply("Alex", 20);
		System.out.println(nameToUpperCase);
	}

}
