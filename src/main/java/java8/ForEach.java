package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ForEach {

	public static void main(String[] args) {		
		Stream.of("a", "b", "c").parallel().forEachOrdered(System.out::println);

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
		
		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		items.entrySet().stream() 
		   .filter(entry -> entry.getValue() > 30) 
		   .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
		
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
		
		listItems.stream()
		.filter(s->{ if((s.contains("B")) || s.contains("C")) return true; return false;})
		.forEach(System.out::println);

	}

}
