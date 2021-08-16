package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInnerAndLambda {

	public static void main(String[] args) {
	
		List<Person> persons = Arrays.asList(
                new Person("Vinay", 30),
                new Person("Krishna", 31),
                new Person("Angel", 22),
                new Person("Krishna", 1)
        );
		
		// using Inner class
		Predicate<Person> pred = new Predicate<Person>() {
			@Override
			public boolean test(Person p) {				
				return p.getAge() > 29;
			}
		};
		
		for (Person person : persons) {
			if(pred.test(person)) {
				System.out.println(person.toString());
			}
		}
		// using lambda
		Predicate<Person> predYounger = (p) -> p.getAge() < 29;
		Predicate<Person> predOlder = (p) -> p.getAge() > 29;
		displayPeople(persons, predYounger);
		displayPeople(persons, predOlder);

	}

	private static void displayPeople(List<Person> persons, Predicate<Person> pred) {
		persons.forEach(p -> {
			if(pred.test(p)) {
				System.out.println(p);
			};
		});
	}

}
