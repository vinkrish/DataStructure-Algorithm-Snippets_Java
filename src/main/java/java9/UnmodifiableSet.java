package java9;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnmodifiableSet {

	public static void main(String[] args) {

		/*
		 * Performing add, update or delete operation on source Set specified to Collections.unmodifiableSet() 
		 * then the unmodifiable Set returned by this method will also change.
		 */
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		
		Set<String> unmodSet = Collections.unmodifiableSet(set);
		System.out.println(unmodSet);
		
		set.add("D");
		System.out.println(unmodSet);

	}

}
