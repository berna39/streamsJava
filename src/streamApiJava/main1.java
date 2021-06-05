package streamApiJava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = getPeople();
		
		// imperative approach
		
		// for exemple if i want to have only female people (we'll have to specify every single detail)
		System.out.println("===== Filtering basic ======");
		List<Person> females = new ArrayList<Person>();
		
		for(Person person: people) {
			if(person.getGender().equals(Gender.FEMALE)) {
				females.add(person);
			}
		}
		
		females.forEach(System.out::println);
		
		
		System.out.println("===== Filtering int declarative mode ======");
		// declarative approach
		//filter
		List<Person> females1 = people.stream()
			 	.filter(person -> person.getGender().equals(Gender.FEMALE))
			 	.collect(Collectors.toList());
		females1.forEach(System.out::println);
		
		
		//sort
		System.out.println("===== Sorting======");
		List<Person> sorted  = people.stream()
									.sorted(Comparator.comparing(Person::getAge))
									.collect(Collectors.toList());
		sorted.forEach(System.out::println);
		
		//sort reversed
		System.out.println("===== Sorting reversed ======");
		List<Person> reversedSorted  = people.stream()
									.sorted(Comparator.comparing(Person::getAge).reversed())
									.collect(Collectors.toList());
		reversedSorted.forEach(System.out::println);
		
		//sort reversed
		System.out.println("===== Sorting reversed then comparing ======");
		List<Person> reversedSortedAndComparing  = people.stream()
									.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
									.collect(Collectors.toList());
		reversedSortedAndComparing.forEach(System.out::println);
		
		// all match
		System.out.println("===== All match ======");
		boolean AllBiggerThanTen = people.stream()
										.allMatch(person -> person.getAge() > 10);
		System.out.println(AllBiggerThanTen);
		//any match
		System.out.println("===== All match ======");
		boolean anyBiggerThanFifty = people.stream()
										.anyMatch(person -> person.getAge() > 50);
		System.out.println(anyBiggerThanFifty);
		//none match
		System.out.println("===== None match ======");
		boolean noneMatch = people.stream()
										.anyMatch(person -> person.getName().equals("Kabuto"));
		System.out.println(noneMatch);
		
		//Max(Age)
		
		System.out.println("===== Max match ======");
		people.stream().max(Comparator.comparing(Person::getAge))
						.ifPresent(System.out::println);
		
		//Min(Age)
		System.out.println("===== Min match ======");
		people.stream().min(Comparator.comparing(Person::getAge))
						.ifPresent(System.out::println);
		
		//Group
	}

	private static List<Person> getPeople(){
		return List.of(
				new Person("Sasuke uchiwa",Gender.MALE,14),
				new Person("Hitachi uchiwa",Gender.MALE,24),
				new Person("Obito uchiwa",Gender.MALE,32),
				new Person("Kuchina uzunaki",Gender.FEMALE,28),
				new Person("Sakura",Gender.FEMALE,24),
				new Person("Naruto uzumaki",Gender.MALE,14),
				new Person("Kabuto",Gender.MALE,44)
		);
	}
}
