package java9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOf {

	public static void main(String[] args) {
		
		final List<String> list = new ArrayList<String>(Arrays.asList("one", "two", "three"));
	    final List<String> unmodifiableList = List.of(list.toArray(new String[]{}));
	    
	    /**
	     * unmodifiableList.add("four");
	     * 
	     * Exception in thread "main" java.lang.UnsupportedOperationException
			at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
			at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:147)
			at java9.ListOf.main(ListOf.java:13)
	     */

	}

}
