package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("apple");
		set.add("banana");
		set.add("apple");  // Duplicates are ignored

		set.remove("apple");

		boolean hasApple = set.contains("apple");  // Checks if "apple" is in the set

		int size = set.size();  // Returns the number of elements in the set

		boolean isEmpty = set.isEmpty();  // Checks if the set is empty
		
		// Using a for-each loop
		for (String item : set) {
		    System.out.println(item);
		}

		// Using an iterator
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
		    System.out.println(iterator.next());
		}
		
		Set<String> anotherSet = new HashSet<>(Set.of("apple", "cherry", "banana"));
		set.addAll(anotherSet);  // Adds all elements from anotherSet to set
		set.removeAll(anotherSet);  // Removes all elements that are also in anotherSet
		set.retainAll(anotherSet);  // Retains only elements present in anotherSet
		
		Object[] array = set.toArray();  // Converts set to an array
		
		boolean isEqual = set.equals(anotherSet);  // Checks if set and anotherSet are equal

		set.clear();  // Removes all elements from the set
	}

}
