package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		java.util.Map<String, Integer> map = new HashMap<>();
		map.put("apple", 1);
		map.put("banana", 2);
		map.put("apple", 10);  // Updates the value for "apple" key

		Integer value = map.get("apple");  // Returns 10
		Integer notFound = map.get("cherry");  // Returns null (key does not exist)

		map.remove("banana");  // Removes the "banana" key-value pair
		map.remove("apple", 10);  // Removes "apple" only if the value is 10

		int size = map.size();  // Returns the number of key-value pairs

		boolean hasApple = map.containsKey("apple");  // Checks if "apple" key exists
		boolean hasValue2 = map.containsValue(2);  // Checks if any key maps to value 2
		
		Integer defaultValue = map.getOrDefault("unknownKey", 0);  // Returns 0 if "unknownKey" is not found

		// Iterating over key-value pairs
		for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}

		// Iterating over keys
		for (String key : map.keySet()) {
		    System.out.println("Key: " + key);
		}

		// Iterating over values
		for (Integer v : map.values()) {
		    System.out.println("Value: " + v);
		}
		
		Set<String> keys = map.keySet();  // Get all the keys
		Collection<Integer> values = map.values();  // Get all the values
		Set<java.util.Map.Entry<String, Integer>> entries = map.entrySet();  // Get all key-value pairs

		
		map.replace("apple", 20);  // Replaces the value for "apple" with 20
		map.replace("apple", 20, 30);  // Replaces only if the current value is 20

		map.merge("apple", 5, (oldValue, newValue) -> oldValue + newValue);  // Adds 5 to the existing value
		
		// Bulk operations
		java.util.Map<String, Integer> newMap = new HashMap<>();
		newMap.put("orange", 4);
		newMap.putAll(map);  // Adds all entries from `map` to `newMap`
		
		// Computing Values
		map.compute("apple", (key, val) -> (val == null) ? 1 : val + 1);  // Increment value or set to 1 if absent
		map.computeIfAbsent("orange", key -> 3);  // Adds "orange" with value 3 if key is absent
		map.computeIfPresent("apple", (key, val) -> val * 2);  // Doubles the value for "apple" if present
		
		map.clear();  // Removes all key-value pairs
		
		boolean isEmpty = map.isEmpty();  // Checks if the map is empty
	}

}
