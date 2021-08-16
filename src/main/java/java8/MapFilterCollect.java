package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFilterCollect {
	
	public static void main(String[] args) {
	    List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
	    System.out.println("original list: " + numbers);
	    List<Integer> even = numbers.stream()
	                                .map(s -> Integer.valueOf(s))
	                                .filter(number -> number % 2 == 0)
	                                .collect(Collectors.toList());
	    System.out.println("processed list, only even numbers: " + even);
	    
	    
	    List<Person> persons = Arrays.asList(
                new Person("Vinay", 30),
                new Person("Krishna", 20),
                new Person("Angel", 21)
        );
	    
	    String name = persons.stream()
                .filter(x -> "Krishna".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
	  }

}
