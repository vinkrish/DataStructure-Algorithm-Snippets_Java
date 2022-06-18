package java12;

import java.util.Optional;
import java.util.function.Function;

public class NewString {

	public static void main(String[] args) {
		String test = "Hello World!";
		
		String text = "Hello\nWorld!";
		System.out.println(text.indent(3));
		
		Integer length = text.transform(String::length); // Transform String to Integer
        System.out.println(length);
		
		String str = "Hello World!";
		String result = str.transform(s -> s.toUpperCase());
		System.out.println(result);
		
		// Custom transformation function: Reverse the string
        Function<String, String> reverseFunction = s -> new StringBuilder(s).reverse().toString();
        String reverse = test.transform(reverseFunction);
        System.out.println(reverse);
        
        // above lambda expression can be replaced with anonymous inner class
        Function<String, String> reversedFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return new StringBuilder(s).reverse().toString();
            }
        };
        String reversed = test.transform(reversedFunction);
        System.out.println(reversed);

		String s = "Hello World!";
		Optional<String> constable = s.describeConstable();
		System.out.println(constable.get());
	}

}
