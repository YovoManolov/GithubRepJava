package streams;
import java.util.List;
import java.util.function.Predicate;
public class _Stream {
	
	public static void main(String[] args) {
		
		List<Person> people = List.of(
				new Person("John", Gender.MALE),
				new Person("Maria", Gender.FEMALE),
				new Person("John", Gender.FEMALE),
				new Person("Alex", Gender.MALE),
				new Person("Alice", Gender.FEMALE),
				new Person("Bob", Gender.PREFFER_NOT_TO_SAY)
				);
		
		/*people.stream()
			.map(person-> person.name)
			.mapToInt(String::length)
			.forEach(System.out::println);*/
		
		 Predicate<Person> personPredicate = 
				 	person -> Gender.FEMALE.equals(person.gender);
		 
		boolean containsOnlyFemales = people.stream().anyMatch(personPredicate);
		System.out.println(containsOnlyFemales);
	}
	
	static class Person {
		
		private final String name;
		private final Gender gender;
		
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
	}
	
	enum Gender { 
		MALE, FEMALE, PREFFER_NOT_TO_SAY
	}
}
