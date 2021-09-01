package reification;

import java.util.Arrays;
import java.util.List;

/*
 * It is illegal to cast a list of objects to a list of strings, so the cast must take place in two steps. 
 * First, cast the list of objects into a list of wildcard type; this cast is safe. 
 * Second, cast the list of wildcard type into a list of strings.
 *  
 * This cast is permitted but generates an unchecked warning:
 * javac -Xlint:unchecked Promote.java
 */
public class Promote {
	
	/*
	 * The method promote loops over the list of objects and throws a class cast exception if any object is not a string. 
	 * Hence, when the last line of the method is reached, it is safe to cast the list of objects to a list of strings.
	 */
	@SuppressWarnings("unchecked")
	public static List<String> promote(List<Object> objs) {
		for (Object o : objs)
		if (!(o instanceof String))
		throw new ClassCastException();
		return (List<String>)(List<?>)objs; // unchecked cast
	}
	
	public static void main(String[] args) {
		List<Object> objs1 = Arrays.<Object>asList("one","two");
		List<Object> objs2 = Arrays.<Object>asList(1,"two");
		List<String> strs1 = promote(objs1);
		assert (List<?>)strs1 == (List<?>)objs1;
		boolean caught = false;
		try {
			List<String> strs2 = promote(objs2);
		} catch (ClassCastException e) { caught = true; }
		assert caught;
	}
}
