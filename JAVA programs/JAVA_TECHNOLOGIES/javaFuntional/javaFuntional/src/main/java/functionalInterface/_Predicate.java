package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
	
	public static void main(String[] args) {
		//sout without predicate
		System.out.println(isPhoneNumberValid("070000000000"));
		System.out.println(isPhoneNumberValid("07000985435"));
		System.out.println(isPhoneNumberValid("090009854353"));
		
		System.out.println();
		//sout with predaicate 
		System.out.println(
				isPhoneNumberValidPredicate.test("070000000000"));
		System.out.println(
				isPhoneNumberValidPredicate.test("07000985435"));
		System.out.println(
				isPhoneNumberValidPredicate.test("090009854353"));
	
		System.out.println(
				"Is phone number valid and contains number 3 = " +
				isPhoneNumberValidPredicate.
				and(containsNumber3).test("090009854353")
		);
		
		System.out.println(
				"Is phone number valid and contains number 3 = " +
				isPhoneNumberValidPredicate.
				and(containsNumber3).test("070000000003")
		);
		
	}
	
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07")
				&& phoneNumber.length() == 12;
	}
	
	static Predicate<String> isPhoneNumberValidPredicate = 
			phoneNumber -> phoneNumber.startsWith("07")
			&& phoneNumber.length() == 12;
			
	static Predicate<String> containsNumber3 = phoneNumber -> 
		phoneNumber.contains("3");
}
