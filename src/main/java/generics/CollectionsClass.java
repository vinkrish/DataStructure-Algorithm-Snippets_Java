package generics;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class CollectionsClass {
	
	/*
	 * The method max takes a collection of type Collection<T> and returns a T, 
	 * and it does this for any type T such that T is a subtype of Comparable<T>.
	 * 
	 * <T extends Comparable<T>> => T is bounded by Comparable<T>.
	 * As with wildcards, bounds for type variables are always indicated by the keyword extends,
	 */
	public static <T extends Comparable<T>> T max(Collection<T> coll) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (candidate.compareTo(elt) < 0) candidate = elt;
		}
		return candidate;
	}
	
	public static <T extends Comparable<T>> T maxEfficient(Collection<T> coll) {
		Iterator<T> it = coll.iterator();
		T candidate = it.next();
		while (it.hasNext()) {
			T elt = it.next();
			if (candidate.compareTo(elt) < 0) candidate = elt;
		}
		return candidate;
	}
	
	/*
	 * replacing type parameter with a wildcard, type signature now becomes:
	 * 
	 * <T extends Comparable<? super T>> T max(Collection<? extends T> coll)
	 * 
	 * Following the Get and Put Principle, 
	 * above we used extends with Collection because we get values of type T from the collection, 
	 * and we use super with Comparable because we put value of type T into the compareTo method
	 */
	
	/*
	 * For every generic method with a type variable bounded by Comparable, 
	 * there is another generic method with an additional argument of type Comparator.
	 */
	
	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (cmp.compare(candidate, elt) < 0) { candidate = elt; }
		}
		return candidate;
	}
	
	// Comparator that provides the natural ordering
	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) { return o1.compareTo(o2); }
		};
	}
	
	/* Using above comparator, we can define version of max that uses the natural ordering in terms of the version that uses a given comparator
	 * 
	 * A type parameter must be explicitly supplied for the invocation of the generic method naturalOrder, 
	 * since the algorithm that infers types would fail to work out the correct type otherwise.
	 */
	public static <T extends Comparable<? super T>> T maxNaturalOrder(Collection<? extends T> coll) {
		return max(coll, CollectionsClass.<T>naturalOrder());
	}

}

/*
	interface Comparable<T> {
		public int compareTo(T o);
	}
	
	interface Comparator<T> {
		public int compare(T o1, T o2);
		public boolean equals(Object obj);
	}
*/
