package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEach {

	public static void main(String[] args) {
		// Normal way to loop a map
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}
		
		// java 8 way of forEach with lambda
		Map<String, Integer> itemz = new HashMap<>();
		itemz.put("A", 10);
		itemz.put("B", 20);
		itemz.put("C", 30);
		itemz.put("D", 40);
		itemz.put("E", 50);
		itemz.put("F", 60);
		
		itemz.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		itemz.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		// Normal way to loop a list
		List<String> listItems = Arrays.asList("A", "B", "C", "D", "E");

		for(String item : listItems){
			System.out.println(item);
		}
		
		// java 8 way
		
		//lambda
		listItems.forEach(item->System.out.println(item));

		listItems.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});
			
		//method reference
		listItems.forEach(System.out::println);
		
		//Stream and filter
		listItems.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);

	}

}
