package java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import javax.annotation.Nonnull;
import lombok.NonNull;

/**
 * No need to compile, just run: java FeatureTest.java
 */
public class FeatureTest {
    public static void main(String[] args) {
        String multilineString = "This is a text \n \n from \n new line!";

        // introducing lines() stream
        List<String> lines = multilineString.lines()
            .filter(line -> !line.isBlank())
            .map(String::strip)
            .collect(Collectors.toList());

        System.out.println(lines);

        // introducing toArray()
        String[] arr = lines.toArray(String[]::new);
        
        for(String s: arr) System.out.println(s);

        lines.add(" ");
        System.out.println(lines);

        // introducing not method in Predicate
        List<String> withoutBlanks = lines.stream()
            .filter(Predicate.not(String::isBlank))
            .collect(Collectors.toList());

        System.out.println(withoutBlanks);

        // introducing local-variable syntax
        String resultString = lines.stream()
            .map((@NonNull var x) -> x.toUpperCase())
            .collect(Collectors.joining(", "));

        System.out.println(resultString);

    }

}
