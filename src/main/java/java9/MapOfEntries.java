package java9;

import java.util.Map;
import static java.util.Map.entry;

import java.util.List;

public class MapOfEntries {

	public static void main(String[] args) {
		// Immutable Map
		Map<Integer, String> map = Map.ofEntries(
				entry(101, "A"),
				entry(102, "B"),
				entry(103, "C")
			);
		map.forEach((k, v) -> System.out.println(k + " - " + v));
			
		// Immutable Map with Immutable List
		List<String> imtList1 = List.of("A1", "B1");
		List<String> imtList2 = List.of("A2", "B2");	
		
		Map<Integer, List<String>> map2 = Map.ofEntries(
			entry(111, imtList1),
			entry(222, imtList2)
		);
		System.out.println(map2);
		
		// Similar approach to MapOf...
	}

}
