package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToList {

	public static void main(String[] args) {
		
		Stream<String> language = Stream.of("java", "python", "node");

        // Convert a Stream to List
        List<String> result = language.collect(Collectors.toList());
        result.forEach(System.out::println);
        
        // You can only use stream once, it will be closed after that
        List<String> sameResult = Stream.of("java", "python", "node")
        		.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sameResult);

	}

}
