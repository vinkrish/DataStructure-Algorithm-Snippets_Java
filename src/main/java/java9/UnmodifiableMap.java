package java9;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMap {

	/*
	 * If we perform add, update or delete operation on source Map specified to Collections.unmodifiableMap() 
	 * then the unmodifiable Map returned by this method will also change.
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(101, "A");
		map.put(102, "B");	
		
		Map<Integer, String> unmodMap = Collections.unmodifiableMap(map);
		System.out.println(unmodMap);
		
		map.put(103, "C");	
		System.out.println(unmodMap);

	}

}
