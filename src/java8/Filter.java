package java8;

import java.util.Arrays;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
                new Person("Vinay", 30),
                new Person("Krishna", 20),
                new Person("Angel", 21)
        );

        Person result1 = persons.stream()
                .filter((p) -> "Krishna".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("Krishna".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);

	}

}
