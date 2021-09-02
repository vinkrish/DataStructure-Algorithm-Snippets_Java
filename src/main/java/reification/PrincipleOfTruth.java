package reification;

import java.lang.reflect.Array;
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
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "two");
		
		String[] a = Right.toArray(strings, new String[0]);
		for(String s: a) System.out.println(s);
		
		String[] b = new String[] { "x","x","x","x" };
		
		System.out.println();
		Right.toArray(strings, b);
		for(String s: b) System.out.println(s);
		
		System.out.println();
		List<String> slist = Arrays.asList("ondu", "eradu");
		String[] c = RightWithClass.toArray(slist, String.class);
		for(String s: c) System.out.println(s);
	}

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

/*
 * one way to get a new array of a generic type is to already have an array of that type. 
 * Then the reified type information for the new array can be copied from the old.
 */
class Right {
	
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(Collection<T> c, T[] a) {
		if (a.length < c.size())
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), c.size()); // unchecked cast 
		int i=0; 
		for (T x : c) a[i++] = x;
		if (i < a.length) a[i] = null;
		return a;
	}
	
	/*
	 * toArray() uses three methods from the reflection library to allocate a new array with the same component type as the old array: 
	 * the method getClass (in java.lang.Object) returns a Class object representing the array type, T[].
	 * the method getComponentType (from java.lang.Class) returns a second Class object representing the array’s component type, T.
	 * and the method newInstance (in java.lang.reflect.Array) allocates a new array with the given component type and size. 
	 * The result type of the call to newInstance is Object, so an unchecked cast is required to cast the result to the correct type T[].
	 */
	
}


/*
 * We can define a variant of our previous method that accepts a class token of type Class<T> rather than an array of type T[].
 * Applying newInstance to a class token of type Class<T> returns a new array of type T[], with the component type specified by the class token. 
 * The newInstance method still has a return type of Object (because of the same problem with primitive arrays), so an unchecked cast is still required.
 */
class RightWithClass {
	public static <T> T[] toArray(Collection<T> c, Class<T> k) {
		
		@SuppressWarnings("unchecked")
		T[] a = (T[]) Array.newInstance(k, c.size()); // unchecked cast
		int i=0; for (T x : c) a[i++] = x;
		return a;
	}
}
