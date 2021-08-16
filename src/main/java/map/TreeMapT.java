package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapT {

	public static void main(String[] args) {
		int arr[] = {10, 34, 5, 10, 3, 5, 10};
        printFreq(arr);
	}
	
	// This function prints frequencies of all elements
    static void printFreq(int arr[])
    {
        // Creates an empty TreeMap
        TreeMap<Integer, Integer> tmap =
                     new TreeMap<Integer, Integer>();
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            Integer c = tmap.get(arr[i]);
 
            // If this is first occurrence of element   
            if (tmap.get(arr[i]) == null)
               tmap.put(arr[i], 1);
 
            // If elements already exists in hash map
            else
              tmap.put(arr[i], ++c);
        }
 
        // Print result
        for (Map.Entry<Integer, Integer> m:tmap.entrySet())
          System.out.println("Frequency of " + m.getKey() + 
                             " is " + m.getValue());
    }
 

}
