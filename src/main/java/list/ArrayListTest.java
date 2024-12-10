package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {

	public static void main(String[] args) {
		
		String[] arrayList = {"A", "B", "C"};
		List<String> fixedList = Arrays.asList(arrayList); // Fixed-size list
		List<String> resizableList = new ArrayList<>(Arrays.asList(arrayList)); // Resizable list

		// size of ArrayList
        int n = 5;
 
        //declaring ArrayList with initial size n
        List<Integer> arrli = new ArrayList<>(n);
 
        // Appending the new element at the end of the list
        for (int i=1; i<=n; i++)
            arrli.add(i);
 
        // Printing elements
        System.out.println(arrli);
 
        // Remove element at index 3
        arrli.remove(3);
 
        // Displaying ArrayList after deletion
        System.out.println(arrli);
 
        // Printing elements one by one
        for (Integer i: arrli)
            System.out.print(i+" ");
        
        System.out.println("");
        System.out.println("Create list with some elements:");
        List<String> list = new ArrayList<>(List.of("b", "c", "e"));  // Create with elements
        list.add("e");
        list.add(0, "a");  // Inserts at index 0
        System.out.println(list);
        list.set(4, "d");
        System.out.println(list);
        list.remove("e"); // remove by object
        System.out.println(list);
        
        int size = list.size();  // Get the number of elements
        boolean exists = list.contains("c");  // Check if "Hello" is in the list
        int firstIndex = list.indexOf("a");  // Get index of the first occurrence of "a"
        boolean isEmpty = list.isEmpty();  // Check if the list is empty
        list.sort(null);  // Sorts in natural order
        
        List<String> subList = list.subList(1, 3);  // Get sublist from index 1 to 2 (exclusive of 3)
        System.out.println(subList);

        System.out.println("Array value:");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
        
        List<String> anotherList = new ArrayList<>(List.of("x", "y", "z"));
        list.addAll(anotherList);  // Adds all elements from anotherList to list
        list.removeAll(anotherList);  // Removes all elements that are also in anotherList
        list.retainAll(anotherList);  // Retains only the elements present in anotherList
        
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());  // Iterating forward
        }


        list.clear();  // Empties the list
	}

}
