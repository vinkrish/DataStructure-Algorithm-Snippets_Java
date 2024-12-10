package java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Apple");

        Map<String, Long> fruitCount = fruits.stream()
            .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));

        System.out.println(fruitCount); // Output: {Apple=3, Banana=2, Orange=1}
        
        // toSet
        List<String> list = Stream.of("A", "B", "C").collect(Collectors.toList());
        System.out.println(list); // Output: [A, B, C]

        // toSet
        Set<String> set = Stream.of("A", "B", "A").collect(Collectors.toSet());
        System.out.println(set); // Output: [A, B]

        // toMap
        Map<String, Integer> map = Stream.of("Apple", "Banana", "Cherry")
        	    .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map); // Output: {5=Apple, 6=Banana, 6=Cherry} (may throw if keys clash)
        	
    	Map<Integer, String> mapDuplicate = Stream.of("Apple", "Banana", "Cherry")
    		    .collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1));
    	System.out.println(mapDuplicate); // Output: {5=Apple, 6=Banana}

    	// joining
    	String result = Stream.of("A", "B", "C").collect(Collectors.joining(", "));
    	System.out.println(result); // Output: A, B, C

    	// counting 
    	long count = Stream.of(1, 2, 3).collect(Collectors.counting());
    	System.out.println(count); // Output: 3

    	// Summary Statistics
    	IntSummaryStatistics stats = Stream.of(1, 2, 3, 4, 5)
        .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(stats); // Output: IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}

        // PartitioningBy
        Map<Boolean, List<Integer>> partition = Stream.of(1, 2, 3, 4, 5)
        	    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partition); // Output: {false=[1, 3, 5], true=[2, 4]}


        // groupingBy
        Map<Integer, List<String>> grouped = Stream.of("Apple", "Banana", "Cherry")
        	    .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped); // Output: {5=[Apple], 6=[Banana, Cherry]}

        // mapping
        List<Integer> lengths = Stream.of("Apple", "Banana", "Cherry")
        	    .collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(lengths); // Output: [5, 6, 6]
        // can be done with stream.map
        List<Integer> lengths2 = Stream.of("Apple", "Banana", "Cherry").map(String::length).toList(); // toList returns unmodifiable list
        System.out.println(lengths2);
        
        // reducing
        int sum = Stream.of(1, 2, 3, 4)
        	    .collect(Collectors.reducing(0, Integer::sum));
        System.out.println(sum); // Output: 10


	}

}
