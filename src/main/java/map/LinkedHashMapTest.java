package map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		lhm.put("one", "practice.geeksforgeeks.org");
		lhm.put("two", "code.geeksforgeeks.org");
		lhm.put("four", "quiz.geeksforgeeks.org");

		// It prints the elements in same order as they were inserted
		System.out.println(lhm);

		System.out.println("Getting value for key 'one': " + lhm.get("one"));
		System.out.println("Size of the map: " + lhm.size());
		System.out.println("Is map empty? " + lhm.isEmpty());
		System.out.println("Contains key 'two'? " + lhm.containsKey("two"));
		System.out.println(
				"Contains value 'practice.geeksforgeeks.org'? " + lhm.containsValue("practice.geeksforgeeks.org"));
		System.out.println("delete element 'one': " + lhm.remove("one"));
		System.out.println(lhm);
		
		Object key = lhm.keySet().iterator().next();
		System.out.println(key);
		
		Iterator<String> iterator = lhm.keySet().iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		
		lhm.clear();
		
		LinkedHashMap<Integer, Integer> li_hash_map =  new LinkedHashMap<Integer, Integer>() {		
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	            return size() > 2; 
	        } 
	    };
	
	}

}
