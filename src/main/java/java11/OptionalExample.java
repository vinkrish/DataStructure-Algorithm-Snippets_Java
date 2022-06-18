package java11;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        // isEmpty() returns true if the Optional is empty
        System.out.println(optional.isEmpty()); // true

        // or() provides an alternative Optional if the current one is empty
        Optional<String> alternative = optional.or(() -> Optional.of("Default"));
        System.out.println(alternative.get()); // Output: Default
    }
}

