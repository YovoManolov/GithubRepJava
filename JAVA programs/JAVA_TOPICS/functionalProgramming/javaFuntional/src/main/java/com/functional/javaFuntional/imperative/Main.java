package com.functional.javaFuntional.imperative;

import static com.functional.javaFuntional.imperative.Main.Gender.FEMALE;
import static com.functional.javaFuntional.imperative.Main.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		List<Person> people = List.of(
				new Person("John", MALE),
				new Person("Maria", FEMALE),
				new Person("John", FEMALE),
				new Person("Alex", MALE),
				new Person("Alice", FEMALE)
				);
		
		List<Person> females = new ArrayList<>();
		for(Person person: people) {
			
			if(FEMALE.equals(person.gender)) {
				females.add(person);
			}
		}
		
		for(Person female: females) {
			 System.out.println(female.toString());
		}
		
		
		Predicate<Person> personPredicate = 
				person -> FEMALE.equals(person.gender);
		//Declarative approach
		List<Person> females2 = people.stream()
				.filter(personPredicate)
				.collect(Collectors.toList());
				
		females2.forEach(System.out::println);
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
		MALE, FEMALE
	}
}
