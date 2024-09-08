package java10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnmodifiableCollectorExample {
    public static void main(String[] args) {
        List<String> names = Stream.of("Alice", "Bob", "Charlie")
                                   .collect(Collectors.toUnmodifiableList());
        System.out.println(names);

        // Trying to modify will throw an exception
        names.add("David");  // Throws UnsupportedOperationException
    }
}

/*
 * Java 10 enhanced the Collectors utility by adding methods to create unmodifiable collections. 
 * This means that any attempt to modify the collection will result in an UnsupportedOperationException.
 */
