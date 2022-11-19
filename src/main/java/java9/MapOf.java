package java9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapOf {

	public static void main(String[] args) {
		// Immutable Map
		Map<Integer, String> map = Map.of(101, "A", 102, "B", 103, "C");
		map.forEach((k, v) -> System.out.println(k + " - " + v));
		
		/** 
		 * map.put(104, "SS"); 
		 * Exception in thread "main" java.lang.UnsupportedOperationException
			at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
			at java.base/java.util.ImmutableCollections$AbstractImmutableMap.put(ImmutableCollections.java:1072)
			at java9.MapOf.main(MapOf.java:11)
		 */
		
		// Immutable Map with Immutable List
		List<String> imtList1 = List.of("A1", "B1");
		List<String> imtList2 = List.of("A2", "B2");	
		
		Map<Integer, List<String>> map2 = Map.of(111, imtList1, 222, imtList2);
		System.out.println(map2);
		
		// unmodifiable Map with mutable List
		List<String> list1 = new ArrayList<String>();
		list1.add("A1");
		list1.add("B1");	
		List<String> list2 = new ArrayList<String>();
		list2.add("A2");
		list2.add("B2");	
		
		Map<Integer, List<String>> map3 = Map.of(111, list1, 222, list2);
		System.out.println("Mutable List :" + map3);
		
		list1.add("R1");
		System.out.println("Mutable List :" + map3);
		
		// Immutable Map with custom Immutable class
		CustomImmutableStudent s1 = new CustomImmutableStudent(33, "Vinay");
		CustomImmutableStudent s2 = new CustomImmutableStudent(24, "Angel");

		Map<String, CustomImmutableStudent> map4 = Map.of("one", s1, "two", s2);
		map4.forEach((k, v) -> System.out.println(k + " - " + v.getName()));
	}

}

final class CustomImmutableStudent {
    final private int age;  
    final private String name;
    public CustomImmutableStudent(final int age, final String name) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
      return age;
    }

    public String getName() {
      return name;
    }
} 
