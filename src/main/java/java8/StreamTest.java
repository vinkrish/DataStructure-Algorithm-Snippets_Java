package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		// Stream from list
		List<String> list = Arrays.asList("Hello", "World", "!");
		Stream<String> streamFromList = list.stream();
		
		// Stream from array
		String[] array = {"a", "b", "c"};
		Stream<String> streamFromArray = Arrays.stream(array);
		
		// Stream from a file
		try {
			Stream<String> streamFromFile = Files.lines(Paths.get("file.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// map
		streamFromList.map(word -> word.toUpperCase()).forEach(word -> System.out.print(word));
		System.out.println();
		streamFromArray.map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		
		List<List<String>> nestedList = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c"));
		nestedList.stream().flatMap(List::stream).forEach(System.out::println); // a b c
		
		// Reduction Operations
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum); // Outputs: 10

		List<String> upperCaseNames = Stream.of("Alice", "Bob")
			    .map(String::toUpperCase)
			    .collect(Collectors.toList());
			System.out.println(upperCaseNames); // Outputs: [ALICE, BOB]
		
		
		Stream<String> language = Stream.of("java", "python", "node");

        // Convert a Stream to List
        List<String> result = language.collect(Collectors.toList());
        result.forEach(System.out::println);
        
        // You can only use stream once, it will be closed after that
        List<String> sameResult = Stream.of("java", "python", "node")
        		.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sameResult);
		
		// Short-Circuiting Operations
		Optional<String> first = Stream.of("a", "b", "c").findFirst();
		first.ifPresent(System.out::println); // Outputs: a
		
		Optional<String> any = Stream.of("a", "b", "c").findAny();
		any.ifPresent(System.out::println); // Outputs: a (or any element in parallel streams)
		
		boolean hasEven = Stream.of(1, 2, 3, 4).anyMatch(x -> x % 2 == 0);
		System.out.println(hasEven); // Outputs: true
		
		boolean allEven = Stream.of(2, 4, 6).allMatch(x -> x % 2 == 0);
		System.out.println(allEven); // Outputs: true
		
		boolean noneEven = Stream.of(1, 3, 5).noneMatch(x -> x % 2 == 0);
		System.out.println(noneEven); // Outputs: true
		
		// Aggregation Operations
		long count = Stream.of("a", "b", "c").count();
		System.out.println(count); // Outputs: 3

		Optional<Integer> max = Stream.of(1, 2, 3).max(Integer::compareTo);
		max.ifPresent(System.out::println); // Outputs: 3

	}

}
