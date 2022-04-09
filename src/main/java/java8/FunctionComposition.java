package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionComposition {
	
	/*
		@FunctionalInterface
		public interface Function<T, R> {
		    R apply(T t);
		}
		
		@FunctionalInterface
		public interface UnaryOperator<T> extends Function<T, T> {}
	 */

	public static void main(String[] args) {
		
		Function<Integer, Integer> multiply = (value) -> value * 2;
		Function<Integer, Integer> add      = (value) -> value + 3;
		
		/*
		 * The Function returned by compose() will first call the Function passed as parameter to compose(), 
		 * and then it will call the Function which compose() was called on
		 */
		Function<Integer, Integer> addThenMultiply = multiply.compose(add);

		Integer result1 = addThenMultiply.apply(3);
		System.out.println(result1);
		
		/*
		 * The Java Function andThen() method works opposite of the compose() method. 
		 * A Function composed with andThen() will first call the Function that andThen() was called on, 
		 * and then it will call the Function passed as parameter to the andThen() method
		 */
		Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

		Integer result2 = multiplyThenAdd.apply(3);
		System.out.println(result2);
		
		// Another example of compose
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> result = math(list,
                x -> x * 2,
                x -> x + 1);

        System.out.println(result); // [3, 5, 7, 9, 11, 13, 15, 17, 19, 21]
	}
	
	public static <T> List<T> math(List<T> list,
            UnaryOperator<T> uo, UnaryOperator<T> uo2) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(uo.andThen(uo2).apply(t));
		}
		return result;
}

}
