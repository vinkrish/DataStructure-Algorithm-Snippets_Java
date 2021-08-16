package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DefaultMethods {

	public static void main(String[] args) {
		Formula formula = new Formula() {
		    @Override
		    public double calculate(int a) {
		        return sqrt(a * 100);
		    }
		};

		System.out.println(formula.calculate(100));     // 100.0
		System.out.println(formula.sqrt(16));           // 4.0
		
		List<People> persons = Arrays.asList(
                new People("Vinay", 30),
                new People("Krishna", 31),
                new People("Angel", 22)
        );
		
		Predicate<People> pred = (p) -> p.getAge() > 29;
		displayPeople(persons, pred);

	}
	
	interface Formula {
	    double calculate(int a);

	    default double sqrt(int a) {
	        return Math.sqrt(a);
	    }
	}
	
	private static void displayPeople(List<People> persons, Predicate<People> pred) {
		persons.forEach(p -> {
			if(pred.test(p)) {
				System.out.println(p.getPersonInfo());
			};
		});
	}

}
