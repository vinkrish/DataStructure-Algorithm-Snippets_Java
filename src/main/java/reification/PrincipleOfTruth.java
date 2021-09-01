package reification;

import java.util.*;

/**
 * The Principle of Truth in Advertising: the reified type of an array must be a subtype of the erasure of its static type.
 */
public class PrincipleOfTruth {
	
	/**
	public static <T> T[] toArray(Collection<T> c) {
		T[] a = new T[c.size()]; // compile-time error
		int i=0; for (T x : c) a[i++] = x;
		return a;
	}
	 * This is an error, because a type variable is not a reifiable type. 
	 */
	
	/*
	public static List<Integer>[] twoLists() {
		List<Integer> a = Arrays.asList(1,2,3);
		List<Integer> b = Arrays.asList(4,5,6);
		return new List<Integer>[] {a, b}; // compile-time error
	}
	 * This is an error, because a parameterized type is not a reifiable type.  
	 */

}

/*
	Integer[] ints = new Integer[] {1,2,3};
	Number[] nums = ints;
	nums[2] = 3.14; // array store exception
 *
 * Running below program:
 * The class cast error message refers to the line containing the call to toArray (line 45).
 * This error message may be confusing, since that line does not appear to contain a cast!
 */
class Wrong {
	public static <T> T[] toArray(Collection<T> c) {
		T[] a = (T[])new Object[c.size()]; // unchecked cast
		int i=0; for (T x : c) a[i++] = x;
		return a;
	}
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one","two");
		String[] a = toArray(strings); // class cast error
	}
}

/* In order to see what went wrong with above program, look at how the program is translated using erasure.
 * 
 * Erasure drops type parameters on Collection and List, 
 * replaces occurrences of the type variable T with Object, 
 * and inserts an appropriate cast on the call to toArray.
 * 
 * The array contains only strings, its reified type indicates that it is an array of Object, so the second cast fails
 */
class WrongAgain {
	public static Object[] toArray(Collection c) {
		Object[] a = (Object[])new Object[c.size()]; // unchecked cast
		int i=0; for (Object x : c) a[i++] = x;
		return a;
	}
	
	public static void main(String[] args) {
		List strings = Arrays.asList(args);
		String[] a = (String[])toArray(strings); // class cast error
	}
}
