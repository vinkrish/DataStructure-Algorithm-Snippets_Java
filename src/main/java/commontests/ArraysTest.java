package commontests;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		System.out.println("copyOfRange:");
		String[] intro = new String[] { "once", "upon", "a", "time" };
		String[] abridgement = Arrays.copyOfRange(intro, 0, 3);
		System.out.println(Arrays.equals(intro, abridgement));
		System.out.println();
		
		System.out.println("copyOf:");
		String[] revised = Arrays.copyOf(intro, 3);
		String[] expanded = Arrays.copyOf(intro, 5);
		System.out.println(Arrays.equals(abridgement, revised));
		System.out.println(expanded[4]); // copyOf pads the array with nulls if our target size is bigger than the original size
		System.out.println();
		
		// fill is useful when we want an array where all elements are the same
		String[] stutter = new String[3];
		Arrays.fill(stutter, "once");
//		assertTrue(Stream.of(stutter).allMatch(el -> "once".equals(el));
		
		/*
		 * deepEquals ultimately calls itself each time it encounters an array
		 * while equals will simply compare sub-arrays references
		 */
		System.out.println("Deep Equals:");
		String[] end = new String[] {"good", "bye"};
		Object[] story = new Object[] 
				  { intro, new String[] { "chapter one", "chapter two" }, end };
		Object[] copy = new Object[] 
				  { intro, new String[] { "chapter one", "chapter two" }, end };
		System.out.println(Arrays.deepEquals(story, copy));
		System.out.println(Arrays.equals(story, copy));
		System.out.println();
		
		// Sort mutates the original reference, which is why we perform a copy here
		String[] sorted = Arrays.copyOf(intro, 4);
		Arrays.sort(sorted);
		
		// binarySearch - if our array isn't first sorted, then binarySearch won't work as we expect!
		System.out.println("Binary Search:");
		int exact = Arrays.binarySearch(sorted, "time");
		System.out.println(exact);
		// If we don't provide a Comparator as a third parameter, then binarySearch counts on our element type being of type Comparable.
		int caseInsensitive = Arrays.binarySearch(sorted, "TiMe", String::compareToIgnoreCase);
		System.out.println(caseInsensitive);
		System.out.println();
		
		/* hashCode and deepHashCode:
		 * deepHashCode is the underlying calculation used when we are working with data structures like HashMap and HashSet on arrays.
		 */
		System.out.println("HashCode and DeepHashCode:");
		Object[] looping = new Object[]{ intro, intro }; 
		int hashBefore = Arrays.hashCode(looping);
		int deepHashBefore = Arrays.deepHashCode(looping);
		intro[3] = null;
		int hashAfter = Arrays.hashCode(looping);
		int deepHashAfter = Arrays.deepHashCode(looping);
		System.out.println(hashBefore == hashAfter);
		System.out.println(deepHashBefore == deepHashAfter);
		System.out.println();
		
		/*
		 * the returned List will be a fixed length so we won't be able to add or remove elements
		 * java.util.Arrays has its own ArrayList subclass, which asList returns
		 */
		List<String> rets = Arrays.asList(intro);
		
		// toString
		System.out.println(Arrays.toString(intro));
		System.out.println(Arrays.deepToString(story));
		System.out.println();
		
		System.out.println("setAll:");
		String[] longAgo = new String[4];
		Arrays.setAll(longAgo, i -> intro[i]); 
		System.out.println(Arrays.toString(longAgo));
		System.out.println();
		
		// Stream
		System.out.println("Stream:");
		Arrays.stream(intro).count();
		long arrayStreamCount = Arrays.stream(intro, 0, 2).count(); // can provide inclusive and exclusive indices for the stream
		System.out.println(arrayStreamCount);
	}

}
