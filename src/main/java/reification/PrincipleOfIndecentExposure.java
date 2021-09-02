package reification;

import java.util.*;

/*
 * Since generic array creation is not permitted, 
 * the array is created with components of the raw type List, 
 * and a cast is used to give the components the parameterized type List<Integer>. 
 * The cast generates an unchecked warning: javac -Xlint:unchecked DeceptiveLibrary.java
 */

public class PrincipleOfIndecentExposure {
	
	/*
	 * Because the unchecked cast appears in the library, no unchecked warning is issued when compiling this code. 
	 * However, running the code overwrites a list of integers with a list of doubles. 
	 * Attempting to extract an integer from the array of lists of integers causes the cast implicitly inserted by erasure to fail
	 */
	public static void main(String[] args) {
		List<Integer>[] intLists = DeceptiveLibrary.intLists(1);
		List<? extends Number>[] numLists = intLists;
		numLists[0] = Arrays.asList(1.01);
		int i = intLists[0].get(0); // class cast error!
	}
	
}

/*
 * Since the array really is an array of lists of integers, the cast appears reasonable, 
 * and you might think that this warning could be safely ignored.
 */
class DeceptiveLibrary {
	
	public static List<Integer>[] intLists(int size) {
		List<Integer>[] intLists = (List<Integer>[]) new List[size]; // unchecked cast
		for (int i = 0; i < size; i++)
			intLists[i] = Arrays.asList(i+1);
		return intLists;
	}
	
}
