package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		System.out.println("copyOfRange:");
		String[] intro = new String[] { "once", "upon", "a", "time" };
		String[] abridgement = Arrays.copyOfRange(intro, 0, 3);
		System.out.println(Arrays.toString(abridgement));
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
		
		System.out.println("Array Fill:");
		int[][] memo = new int[3][2];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(memo[i], -1);
        }
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++)
				System.out.print(memo[i][j]);
			System.out.println("");
		}
		System.out.println();
       
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
		
		// toString
		System.out.println(Arrays.toString(intro));
		System.out.println(Arrays.deepToString(story));
		System.out.println();
		
		// Sort mutates the original reference, which is why we perform a copy here
		String[] sorted = Arrays.copyOf(intro, 4);
		Arrays.sort(sorted);
		
		System.out.println("Sorting Descending:");
		int[] ints = new int[] {1, 2, 3};
		/*
		Arrays.sort(Integers, Collections.reverseOrder());
		Collections.sort(list, Collections.reverseOrder());
		Collections.sort(list, Collections.reverseOrder(new Comparator()));
		*/
		int[] intsDesc = Arrays.stream(ints)
				.boxed()
			    .sorted(Collections.reverseOrder())
			    .mapToInt(Integer::intValue)
			    .toArray();
		printArray(intsDesc);
//		System.out.println(Arrays.toString(intsDesc));
		System.out.println();
		
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
		System.out.println(Arrays.deepToString(looping));
		intro[3] = null;
		System.out.println(Arrays.deepToString(looping));
		int hashAfter = Arrays.hashCode(looping);
		int deepHashAfter = Arrays.deepHashCode(looping);
		System.out.println(hashBefore == hashAfter);
		System.out.println(deepHashBefore == deepHashAfter);
		System.out.println();
		
		System.out.println("looping is not technically 2d array");
		String[][] looping2D = new String[][] { 
		    { "once", "upon", "a", "time" }, 
		    { "once", "upon", "a", "time" } 
		};
		System.out.println(Arrays.deepToString(looping2D));
		System.out.println();
		
		System.out.println("List created from array is not not mutable");
		/*
		 * the returned List will be a fixed length so we won't be able to add or remove elements
		 * java.util.Arrays has its own ArrayList subclass, which asList returns
		 */
		List<String> rets = Arrays.asList(intro);
		try {
			System.out.println(rets);
			rets.add("new");
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println();
		
		System.out.println("One way to make array grow is to create new:");
		String[] newArray = new String[intro.length + 1];
        System.arraycopy(intro, 0, newArray, 0, intro.length);
        newArray[newArray.length - 1] = "story";
        System.out.println(Arrays.toString(newArray));
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
		System.out.println();
		
		// charArray
		System.out.println("Char Array Sort:");
		System.out.println(sort("Array"));
		
		System.out.println("Char Occurence: ");
		alphabetsOccurence("array");
	}
	
	public static void printArray(int[] array) {
		for(int i: array) System.out.print(i);
	}
	
	
	public static String sort(String s) {
		char[] t = s.toCharArray();
		Arrays.sort(t);
		return new String(t);
	}
	 
	public static void alphabetsOccurence(String s) {
		int[] sMap = new int[26];
		for (int i = 0; i < s.length(); i++)
            sMap[s.charAt(i) - 'a']++;
		printArray(sMap);
	}

}
