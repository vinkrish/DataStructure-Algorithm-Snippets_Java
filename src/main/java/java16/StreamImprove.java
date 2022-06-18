package java16;

import java.util.List;
import java.util.stream.Stream;

public class StreamImprove {
    public static void main(String[] args) {
        // Example for toList()
        List<Integer> numbers = Stream.of(1, 2, 3, 4)
                                      .filter(n -> n % 2 == 0)
                                      .toList();  // No need to collect(Collectors.toList())
        System.out.println(numbers);  // Output: [2, 4]
        
        // Example for mapMulti()
        List<Integer> mappedNumbers = Stream.of(1, 2, 3)
                                             .<Integer>mapMulti((num, consumer) -> {
                                                 consumer.accept(num);
                                                 consumer.accept(num * 2);
                                             })
                                             .toList();
        System.out.println(mappedNumbers);  // Output: [1, 2, 2, 4, 3, 6]
    }
}

/* There are two new methods introduced in the Stream API:
	toList() – Returns a new list from the stream.
	mapMulti() – Allows mapping one element to multiple elements.
 */