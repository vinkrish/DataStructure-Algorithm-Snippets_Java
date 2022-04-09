package java8;

import java.util.function.Predicate;

public class PredicateComposition {

	public static void main(String[] args) {
		
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX   = (text) -> text.endsWith("x");
		
		/*
		 * Without composition
		 */
		Predicate<String> startsWithAAndEndsWithX = (text) -> startsWithA.test(text) && endsWithX.test(text);

		String  input0  = "A hardworking person must relax";
		boolean result0 = startsWithAAndEndsWithX.test(input0);
		System.out.println(result0);

		/*
		 * The Predicate and() method is a default method. The and() method is used to combine two other Predicate functions
		 */
		Predicate<String> composedAnd = startsWithA.and(endsWithX);

		String input = "A hardworking person must relax";
		boolean result = composedAnd.test(input);
		System.out.println(result);
		
		/*
		 * The Predicate or() method is used to combine a Predicate instance with another, to compose a third Predicate instance
		 */
		Predicate<String> composedOr = startsWithA.or(endsWithX);

		String input2 = "A hardworking person must relax sometimes";
		boolean result2 = composedOr.test(input2);
		System.out.println(result2);

	}

}
