package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapT {

	public static void main(String[] args) {
		int arr[] = {10, 34, 5, 10, 3, 5, 10};
        printFreq(arr);
	}
	
	// This function prints frequencies of all elements
    static void printFreq(int arr[])
    {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            Integer c = hmap.get(arr[i]);
 
            // If this is first occurrence of element 
            if (hmap.get(arr[i]) == null)
               hmap.put(arr[i], 1);
            else // If elements already exists in hash map
              hmap.put(arr[i], ++c);
        }
 
        // Print result
        for (Map.Entry<Integer, Integer> m:hmap.entrySet())
          System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
        
        // Get all keys
        Set<Integer> keys = hmap.keySet();
        for (Integer k : keys) {
            System.out.println("Key: " + k);
        }

        // Get all values
        Collection<Integer> values = hmap.values();
        for (Integer v : values) {
            System.out.println("Value: " + v);
        }

        // Java 8
        hmap.forEach((k, v) -> {
            System.out.println("Key: " + k + ", Value: " + v);
        });
    }

}
