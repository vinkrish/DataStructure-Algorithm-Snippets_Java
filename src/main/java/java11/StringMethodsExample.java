package java11;

public class StringMethodsExample {
    public static void main(String[] args) {
        String str = "  Hello, Java 11!  ";

        // isBlank() checks if the string contains only whitespace
        System.out.println("".isBlank()); // true
        System.out.println(str.isBlank()); // false

        // strip() removes leading and trailing whitespaces
        System.out.println(str.strip()); // "Hello, Java 11!"

        // stripLeading() removes leading whitespaces
        System.out.println(str.stripLeading()); // "Hello, Java 11!  "

        // stripTrailing() removes trailing whitespaces
        System.out.println(str.stripTrailing()); // "  Hello, Java 11!"

        // repeat() repeats the string
        System.out.println("Java ".repeat(3)); // "Java Java Java "

        // lines() returns a stream of lines in the string
        String multilineString = "Line1\nLine2\nLine3";
        multilineString.lines().forEach(System.out::println);
    }
}
