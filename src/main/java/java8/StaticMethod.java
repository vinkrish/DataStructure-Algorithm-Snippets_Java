package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StaticMethod {

	public static void main(String[] args) {
		
		List<People> persons = Arrays.asList(
                new People("Vinay", 30),
                new People("Krishna", 31),
                new People("Angel", 22)
        );
		
		Predicate<People> pred = (p) -> p.getAge() > 29;
		displayPeople(persons, pred);
	}
	
	private static void displayPeople(List<People> persons, Predicate<People> pred) {
		persons.forEach(p -> {
			if(pred.test(p)) {
				System.out.println(PeopleInterface.getStaticPersonInfo(p));
			};
		});
	}

}
