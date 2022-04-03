package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapT {

	public static void main(String[] args) {
		int arr[] = {10, 34, 5, 10, 3, 5, 10};
        printFreq(arr);
	}
	
	// This function prints frequencies of all elements
    static void printFreq(int arr[]) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
 
        for (int i = 0; i < arr.length; i++) {
            Integer c = tmap.get(arr[i]);
 
            // If this is first occurrence of element   
            if (tmap.get(arr[i]) == null)
               tmap.put(arr[i], 1);
            else // If elements already exists in hash map
              tmap.put(arr[i], ++c);
        }
 
        for (Map.Entry<Integer, Integer> m:tmap.entrySet())
        	System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
        
        // Other common methods
        System.out.println(tmap.containsKey(7));
        System.out.println(tmap.lowerKey(33));
        System.out.println(tmap.higherKey(10));
    }
 

}
