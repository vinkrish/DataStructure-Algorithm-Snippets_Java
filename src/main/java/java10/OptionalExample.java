package java10;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Vinay");

        // Traditional get() approach
        System.out.println(name.get());

        // New orElseThrow() approach (throws NoSuchElementException if value is not present)
        System.out.println(name.orElseThrow());
    }
}

/*
	Java 10 introduced the orElseThrow() method in the Optional class as a better alternative to get() to avoid returning null.
*/