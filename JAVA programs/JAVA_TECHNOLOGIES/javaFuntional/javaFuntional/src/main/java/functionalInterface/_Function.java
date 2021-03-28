package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
		
		// Funtion takes 1 argument and produces 1 result;
		int increment = incrementByOne(1);
		System.out.println(increment);
		
		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);
		
		int multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);
		
		Function<Integer,Integer> addBy1AndMultiplyBy10 = 
					incrementByOneFunction.andThen(multiplyBy10Function);
		System.out.println(addBy1AndMultiplyBy10.apply(1));
		
		// BiFunction takes 2 arguments and produces 1 result;
		System.out.println(incrementByOneAndMultiply(4,100));
		System.out.println(
				incrementByOneAndMultiplyBiFunction.apply(4,100)
		);
		
	}
	
	static Function<Integer, Integer> incrementByOneFunction 
			= number -> ++number;
			
	static Function<Integer, Integer> multiplyBy10Function = 
			number -> number * 10;
			
	static int incrementByOne(int number) {
		return number + 1;
	}
	
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
				(numberToIncrementByOne, numberToMultiplyBy) ->
						(numberToIncrementByOne + 1) * numberToMultiplyBy;

	static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
		return (number + 1) * numToMultiplyBy;
	}
}
