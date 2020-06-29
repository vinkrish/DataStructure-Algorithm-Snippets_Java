package java8;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
                new Person("Vinay", 30),
                new Person("Krishna", 31),
                new Person("Angel", 22),
                new Person("Krishna", 1)
        );

		// passing predicate to filter
        Person result1 = persons.stream()
                .filter((p) -> "Krishna".equals(p.getName()) && 31 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("Krishna".equals(p.getName()) && 31 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);

	}

}
