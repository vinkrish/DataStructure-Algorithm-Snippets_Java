package generics;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class GenericMethod {

	public static void main(String[] args) {
		
		List<Integer> ints = Temp.toList(new Integer[] { 1, 2, 3 }); 
		System.out.println(ints);
		
		List<String> words = Temp.toList(new String[] { "hello", "world" });
		System.out.println(words);
		
		// the type parameter to the generic method is inferred, but it may also be given explicitly
		List<Object> objs = Temp.<Object>toListVararg(1, "two");
		System.out.println(objs);
		
		/*
		 * without the type parameter there is too little information
		 * for the type inference algorithm used by Sun's compiler to infer the correct type 
		 */
		List<Integer> intsExplicit = Temp.<Integer>toListVararg();
		System.out.println(intsExplicit);
		
		List<Integer> intss = Temp.toListVararg(1, 2, 3);
		System.out.println(intss);
		
		List<String> wordss = Temp.toListVararg("hello", "world");
		System.out.println(wordss);
		
		List<Integer> intsAll = new ArrayList<Integer>(); 
		Temp.addAll(intsAll, 1, 2);
		Temp.addAll(intsAll, new Integer[] { 3, 4 });
		System.out.println(intsAll);

	}

}

class Temp {
	
	/*
	 * The static method toList accepts an array of type T[] and returns a list of type List<T>, and does so for any type T
	 */
	public static <T> List<T> toList(T[] arr) {
		List<T> list = new ArrayList<T>(); 
		for (T elt : arr) list.add(elt); 
		return list;
	}
	
	/*
	 * At run time, the arguments are packed into an array which is passed to the method, just as previously
	 */
	public static <T> List<T> toListVararg(T... arr) {
		List<T> list = new ArrayList<T>(); 
		for (T elt : arr) list.add(elt); 
		return list;
	}
	
	/*
	 * Whenever a vararg is declared, one may either pass a list of arguments to be implicitly packed into an array, 
	 * or explicitly pass the array directly
	 */
	public static <T> void addAll(List<T> list, T... arr) {
		for (T elt : arr) list.add(elt); 
	}
	
	/*
	 * Nonreifiable Casts An instance test against a type that is not reifiable is always an error. 
	 * However, in some circumstances a cast to a type that is not reifiable is permitted.
	 */
	public static <T> List<T> asList(Collection<T> c) 
			throws IllegalArgumentException {
		if (c instanceof List<?>) {
			return (List<T>)c;
		} else throw new IllegalArgumentException("Argument not a list");
	}
}
