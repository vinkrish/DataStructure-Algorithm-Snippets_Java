package java8;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
                new Person("Vinay", 35),
                new Person("Krishna", 25),
                new Person("Angel", 26),
                new Person("Dupee", 16)
        );

		// passing predicate to filter
        Person result1 = persons.stream()
                .filter((p) -> "Vinay".equals(p.getName()) && p.getAge() > 25)
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("Angel".equals(p.getName()) && p.getAge() > 16) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);
        
        persons.stream().filter(p -> p.getAge() > 25).forEach(p -> System.out.println(p.getName()));

	}

}
