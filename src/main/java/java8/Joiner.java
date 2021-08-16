package java8;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Joiner {

	public static void main(String[] args) {
		
		String us = String.join(", ", "Vinay", "Krishna", "Angel", "Dupee");
		System.out.println(us);
		
		String[] cats = {"Everest", "Kailani", "Moda"};
		String catsList = String.join(", ", cats);
		System.out.println(catsList);
		
		// StringJoiner
		StringJoiner sj = new StringJoiner(", ", "{ ", " }");
		sj.setEmptyValue("No birds yet");
		System.out.println(sj);
		
		sj.add("Mango")
		.add("Sunshine")
		.add("Kiwi");
		System.out.println(sj);
		
		// Merging StringJoiner instances
		StringJoiner sj2 = new StringJoiner(", ");
		sj2.add("Birdy");
		
		sj.merge(sj2);
		System.out.println(sj);
		
		// working with collections
		Set<String> set = new TreeSet<>();
		set.add("Karnataka");
		set.add("Maharashtra");
		set.add("Delhi");
		
		StringJoiner sj3 = new StringJoiner(" and ");
		set.forEach(s -> sj3.add(s));
		
		System.out.println(sj3);
		
	}

}
